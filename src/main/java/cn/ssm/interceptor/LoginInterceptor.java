package cn.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//获取请求的url字符串
		String url = request.getRequestURI();
		//判断url是否是公开 地址（实际使用时将公开 地址配置配置文件中）
		//这里公开地址是登陆提交的地址
		//判断字符串login.action第一次出现的位置，这里是判断是否存在login.action，不存在输出-1
//		System.out.println(url);
		if(url.contains("login")||url.contains("register")||url.contains("getCaptcha")){
			//如果进行登陆提交，放行 没有这句的话，就无限拦截了，因为无法通过提交页面来获取session，没有session又不能通过拦截
			//这句话的意思就是不拦截登录页面，当然也可以在springmvc配置文件设置拦截的页面，现在是全局拦截
			return true;
		}
		if(request.getSession().getAttribute("id")==null){
			request.setAttribute("loginMsg","您未登录");
			//直接/login.jsp代表项目下的绝对路径 一开始是login.jsp不行
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		return false;
		}else {
			return true;
		}
	}
}
