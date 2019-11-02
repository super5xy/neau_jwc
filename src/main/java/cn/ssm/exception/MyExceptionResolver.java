package cn.ssm.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyExceptionResolver implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
		if (e instanceof MyException) {
			MyException myException = (MyException) e;

			ModelAndView mv = new ModelAndView();
			mv.addObject("errorMsg", myException.getMsg());
			mv.setViewName("error");
			return mv;
		}


		return null;
	}
}
