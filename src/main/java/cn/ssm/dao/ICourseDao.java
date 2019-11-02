package cn.ssm.dao;

import cn.ssm.domain.Course;
import cn.ssm.domain.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("courseDao")
public interface ICourseDao {

	//查询所有课程，和选择每个课程的学生
	List<Course> findAllStudentOfCourse();


}
