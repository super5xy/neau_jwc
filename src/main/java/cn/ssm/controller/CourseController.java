package cn.ssm.controller;


import cn.ssm.domain.Course;
import cn.ssm.service.ICourseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("jwc")
public class CourseController {
	@Autowired
	ICourseService courseService;

	//查询所有课程，和选择每个课程的学生
	@RequestMapping("courseDetail")
	public String findAllStudentOfCourse(Model model){
		List<Course> courses = courseService.findAllStudentOfCourse();
		model.addAttribute("courses",courses);
		return "courseDetail";
	}

}
