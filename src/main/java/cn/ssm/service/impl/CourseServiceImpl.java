package cn.ssm.service.impl;

import cn.ssm.dao.ICourseDao;
import cn.ssm.domain.Course;
import cn.ssm.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("courseService")
public class CourseServiceImpl implements ICourseService {
	@Autowired
	ICourseDao courseDao;

	@Override
	public List<Course> findAllStudentOfCourse() {
		return courseDao.findAllStudentOfCourse();
	}
}
