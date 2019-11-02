package cn.ssm.dao;

import cn.ssm.domain.Account;
import cn.ssm.domain.Course;
import cn.ssm.domain.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentDao")
public interface IStudentDao {
//登录
	Student findStudentByStuidAndPassowrd(Student student);
//注册
	void saveStudent(Student student);
//查询所有的学生信息，除了自己
	List<Student> findAllStudent(Integer id);
//查询自己选的课
	Student findStudentCourse(Integer id);
	void saveCourse(@Param("sid") Integer sid, @Param("cid") Integer cid);

	void deleteCourse(@Param("sid")Integer sid, @Param("cid")Integer cid);
	//查询除了自己已经选的课程，便于选择
	List<Course> findAllCourse(Integer id);

	Student findOneStudentById(Integer id);

	void updateStudent(Student student);

	void updateStudentPassword(Student student);
	void updateStudentFace(Student student);


}
