package cn.ssm.controller;

import cn.ssm.domain.Course;
import cn.ssm.domain.Student;
import cn.ssm.exception.MyException;
import cn.ssm.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("jwc")
public class StudentController {
	@Autowired
	IStudentService studentService;

	@RequestMapping("")
	public String jwc() {

		return "jwc";
	}

	//查询已经选的课 判断null
	@RequestMapping("listCourse")
	public String listCourse(HttpSession session, Model model) {
		Integer id = (Integer) session.getAttribute("id");
		Student studentCourse = studentService.findStudentCourse(id);
		if (studentCourse != null) {
			List<Course> courses = studentCourse.getCourses();

			model.addAttribute("courses", courses);
		}
		return "listCourse";
	}

	//查询可以选的课
	@RequestMapping("listAllCourse")
	public String listAllCourse(HttpSession session, Model model) {
		Integer id = (Integer) session.getAttribute("id");
		List<Course> courses = studentService.findAllCourse(id);
		if (courses != null) {


			model.addAttribute("courses", courses);
		}
		return "listAllCourse";
	}

	//查询除了自己所有学生
	@RequestMapping("findAllStudent")
	public String findAllStudent(HttpSession session, Model model) {
		Integer id = (Integer) session.getAttribute("id");
		List<Student> students = studentService.findAllStudent(id);
		if (students != null) {


			model.addAttribute("students", students);
		}
		return "listStudents";
	}

	//选课
	@RequestMapping("saveCourse")
	public String saveCourse(HttpSession session, Model model, Integer cid) throws MyException {
		Integer sid = (Integer) session.getAttribute("id");
		if (sid == null || cid == null) {
			throw new MyException("您未选择课程");
		}
		studentService.saveCourse(sid, cid);
		model.addAttribute("loginMsg", "选课成功");
		return "forward:listAllCourse";
	}

	//删除选课
	@RequestMapping("deleteCourse")
	public String deleteCourse(HttpSession session, Model model, Integer cid) throws MyException {
		Integer sid = (Integer) session.getAttribute("id");
		if (sid == null || cid == null) {
			throw new MyException("您未选择课程");
		}
		studentService.deleteCourse(sid, cid);

		return "redirect:listCourse";
	}

	//查询自己的资料
	@RequestMapping("myAccount")
	public String findOneStudentById(HttpSession session, Model model) throws MyException {
		Integer sid = (Integer) session.getAttribute("id");
//if (sid==null) {
//	throw new MyException("没有登录信息");
//}

		Student student = studentService.findOneStudentById(sid);
		model.addAttribute("student", student);
		return "myAccount";
	}

	//查询别人的资料
	@RequestMapping("othersAccount")
	public String othersAccount(Model model, Integer id) throws MyException {

		Student student = studentService.findOneStudentById(id);
		model.addAttribute("student", student);
		return "othersAccount";
	}

	//修改资料
	@RequestMapping("editAccount")
	public String editAccount(Model model, HttpSession session) throws MyException {
		Integer sid = (Integer) session.getAttribute("id");
		Student student = studentService.findOneStudentById(sid);
		model.addAttribute("student", student);
		return "editAccount";
	}

	@RequestMapping("editSubmit")
	public String editSubmit(Student student, HttpSession session, Model model) throws MyException {
		if (student.getStuid() == null ||
				student.getName() == null ||
				student.getStuid().length() <= 0 ||
				student.getName().length() <= 0
		) {


			model.addAttribute("loginMsg", "学号和名字不能为空");
			return "myAccount";
		}


		String regex = "^[a-z0-9A-Z]+$";
		if (!student.getStuid().matches(regex)) {
			model.addAttribute("loginMsg", "学号只能由数字和字母组成");
			return "myAccount";
		}


		if (student.getStuid().length() > 9) {
			model.addAttribute("loginMsg", "学号不能超过9位");
			return "myAccount";
		}
		if (student.getName().length() > 10) {
			model.addAttribute("loginMsg", "您的名字太长了！（10字符以内）");
			return "myAccount";
		}
		if (student.getSign().length() > 50) {
			model.addAttribute("loginMsg", "您的个性签名太长了！（50字符以内）");
			return "myAccount";
		}

		Integer sid = (Integer) session.getAttribute("id");
		student.setId(sid);
		studentService.updateStudent(student);
//		System.out.println(student);
		return "redirect:myAccount";
	}

	//获得头像
	@RequestMapping("getFace")
	public void getFace() {

		//1.增加字段
		//2.登录后把用户信息存入session
		//3.从session取出头像地址，判断用户是否有头像信息，没有，显示默认头像，返回默认头像

	}

	//设置头像
	@RequestMapping("setFace")
	public String setFace() {

		//1.jsp增加点击更换头像，创建一个更换头像的表单
		//2.提交后将头像图片地址放入数据库，头像重命名为id值即可（设置仅能上传图片，可限制图片大小）
		//3.判断用户是否有头像信息。

		return "setFace";
	}

	@RequestMapping("setFaceSubmit")
	public String setFaceSubmit(Model model, MultipartFile face, HttpServletRequest request) throws IOException {
		if (face == null) {
			model.addAttribute("loginMsg", "请选择文件");
			return "setFace";
		}
		if (face.getSize() == 0) {
			model.addAttribute("loginMsg", "请选择文件");
			return "setFace";
		}

		if (face.getSize() > 10485760) {
			model.addAttribute("loginMsg", "文件大小超出限制");
			return "setFace";
		}
		//获取绝对路径
		String path = request.getSession().getServletContext().getRealPath("faces");
//		创建绝对路径文件夹
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		Integer id = (Integer) request.getSession().getAttribute("id");
		Student find = studentService.findOneStudentById(id);
		if (find.getFilename()!=null&&find.getFilename().length()>0){
			String filename=path+"\\"+find.getFilename();
//			System.out.println(filename);
			new File(filename).delete();
		}

		//获取文件后缀名
//		String suffix = face.getOriginalFilename().substring(face.getOriginalFilename().lastIndexOf(".")+ 1);
//
//		获取上传文件名称

//		Integer id = (Integer) request.getSession().getAttribute("id");
//		String filename = id.toString()+"."+suffix;

//		写入文件
		String filename = UUID.randomUUID()+"_"+face.getOriginalFilename();
		face.transferTo(new File(path, filename));
		Student student =new Student();
		student.setFilename(filename);
		student.setId(id);
		studentService.updateStudentFace(student);

		//将来从session获取头像数据，这里更新头像数据
		request.getSession().setAttribute("face",filename);
		//提交头像。调用update，存入头像地址和写入文件
		model.addAttribute("loginMsg", "成功");

		return "setFace";
	}


	@RequestMapping("editPassword")
	public String editPassword() {

		return "editPassword";
	}

	@RequestMapping("editPasswordSubmit")
	public String editPasswordSubmit(Model model, HttpSession session, String oldPassword, String newPassword) throws MyException {

		String regex = "^[a-z0-9A-Z]+$";
		if (!newPassword.matches(regex)) {
			model.addAttribute("loginMsg", "密码只能由数字和字母组成");
			return "editPassword";
		}


		if (newPassword.length() > 20) {
			model.addAttribute("loginMsg", "密码不能超过20位");
			return "editPassword";
		}
		Integer sid = (Integer) session.getAttribute("id");
		Student student = studentService.findOneStudentById(sid);
		if (!student.getPassword().equals(oldPassword)) {
			model.addAttribute("loginMsg", "原密码错误");
			return "editPassword";
		}
		student.setPassword(newPassword);
		studentService.editPasswordSubmit(student);
		model.addAttribute("loginMsg", "修改成功");
		return "editPassword";
	}

}
