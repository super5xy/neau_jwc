package cn.ssm.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.ssm.domain.Student;
import cn.ssm.exception.MyException;
import cn.ssm.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {
	@Autowired
	IStudentService studentService;

	@RequestMapping("login")
	public String login(Student student, HttpSession session, Model model) throws MyException {
//		System.out.println("login"+student);
		if (student.getStuid() == null || student.getStuid().length() <= 0 || student.getPassword() == null || student.getPassword().length() <= 0) {
			model.addAttribute("loginMsg", "请输入账号和密码");
			return "forward:login.jsp";
		}

		Student findStudent = studentService.findStudentByStuidAndPassowrd(student);

		//service判断一次null了。可以不判断
		//这样的话windows系统不区分大小写。linux就区分了。也可以判断equals
		if (findStudent != null) {
			//id作为判断登录的依据，name是欢迎的字段
			session.setAttribute("id", findStudent.getId());
			session.setAttribute("name", findStudent.getName());

			session.setAttribute("face",findStudent.getFilename());

			//重定向到选课页面
			return "redirect:jwc";
		} else {
			model.addAttribute("loginMsg", "账号或密码错误");
			return "forward:login.jsp";
		}

	}

	@RequestMapping("logout")
	public String logout(HttpSession session, Model model) throws MyException {

		session.invalidate();

		model.addAttribute("loginMsg", "已退出登录");
		return "forward:login.jsp";
	}

	@RequestMapping("register")
	public String register(Student student, Model model,HttpSession session,String captcha) throws MyException {

//		System.out.println(student);
		String sessionCaptcha = (String) session.getAttribute("captcha");
		if (captcha==null||captcha.length()<=0){
			model.addAttribute("loginMsg", "请输入验证码");
			return "forward:register.jsp";
		}
		if (!captcha.equalsIgnoreCase(sessionCaptcha)){
			model.addAttribute("loginMsg", "验证码错误");
			return "forward:register.jsp";
		}

		if (student.getStuid() == null ||
				student.getPassword() == null ||
				student.getName() == null ||
				student.getStuid().length() <= 0 ||
				student.getPassword().length() <= 0 ||
				student.getName().length() <= 0
		) {


			model.addAttribute("loginMsg", "不能为空");
			return "forward:register.jsp";
		}

		String regex = "^[a-z0-9A-Z]+$";
		if (!student.getStuid().matches(regex)) {
			model.addAttribute("loginMsg", "学号只能由数字和字母组成");
			return "forward:register.jsp";
		}

		if (!student.getPassword().matches(regex)) {
			model.addAttribute("loginMsg", "密码只能由数字和字母组成");
			return "forward:register.jsp";
		}
		if (student.getStuid().length() > 9) {
			model.addAttribute("loginMsg", "学号不能超过9位");
			return "forward:register.jsp";
		}
		if (student.getPassword().length() > 20) {
			model.addAttribute("loginMsg", "密码不能超过20位");
			return "forward:register.jsp";
		}
		if (student.getName().length() > 10) {
			model.addAttribute("loginMsg", "您的名字太长了！（10字符以内）");
			return "forward:register.jsp";
		}


		studentService.saveStudent(student);


		model.addAttribute("loginMsg", "恭喜你成为东北农业大学的一员！");
		return "forward:login.jsp";
	}

	//验证码
	@RequestMapping("getCaptcha")
	public void captcha(HttpServletRequest request,HttpServletResponse response) throws IOException {

		LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);

		String code = lineCaptcha.getCode();
//		获得验证码,存入session
		request.getSession().setAttribute("captcha",code);
		System.out.println(code);
		ServletOutputStream outputStream = response.getOutputStream();
		lineCaptcha.write(outputStream);

//		outputStream.close();不用关，容器自己回收
	}


}
