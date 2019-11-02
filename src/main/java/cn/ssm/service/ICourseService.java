package cn.ssm.service;

import cn.ssm.domain.Course;

import java.util.List;

public interface ICourseService {
	List<Course> findAllStudentOfCourse();
}
