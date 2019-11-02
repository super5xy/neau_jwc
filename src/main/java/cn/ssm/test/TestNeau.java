package cn.ssm.test;


import cn.ssm.domain.Course;
import cn.ssm.domain.Student;
import cn.ssm.exception.MyException;
import cn.ssm.service.ICourseService;
import cn.ssm.service.IStudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestNeau {
	@Test
	public void testlogin() throws MyException {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		IStudentService studentService = (IStudentService) applicationContext.getBean("studentService");
		Student student =new Student();
		student.setStuid("A02150146");
//		student.setPassword("123");
		Student studentByStuidAndPassowrd = studentService.findStudentByStuidAndPassowrd(student);
		System.out.println(studentByStuidAndPassowrd);

	}
	@Test
	public void testregister() throws MyException {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		IStudentService studentService = (IStudentService) applicationContext.getBean("studentService");
		Student student =new Student();
		student.setName("老是");
		student.setStuid("A0215");
		student.setPassword("12");
		studentService.saveStudent(student);


	}
	@Test
	public void testFindAllStudent() throws MyException {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		IStudentService studentService = (IStudentService) applicationContext.getBean("studentService");
//		List<Student> allStudent = studentService.findAllStudent(5);
//		System.out.println(allStudent);

//		Student studentCourse = studentService.findStudentCourse(1);
//		System.out.println(studentCourse);
//		studentService.deleteCourse(1,1);
//		List<Course> allCourse = studentService.findAllCourse(1);
//		System.out.println(allCourse);

//		studentService.saveCourse(5,2);
//		Student oneStudentById = studentService.findOneStudentById(1);
//		System.out.println(oneStudentById);
		ICourseService courseService = (ICourseService) applicationContext.getBean("courseService");
		List<Course> allStudentOfCourse = courseService.findAllStudentOfCourse();
		for (Course course : allStudentOfCourse) {
			System.out.println(course);
		}


	}
}
