package cn.ssm.service;

import cn.ssm.domain.Account;
import cn.ssm.domain.Course;
import cn.ssm.domain.Student;
import cn.ssm.exception.MyException;

import java.util.List;

public interface IStudentService {
	//根据学生查询选课信息 根据id查 因为名字可以重复
	List<Course> findAllCourse(Integer id);

	//查询所有学生（查看同班同学）
	List<Student> findAllStudent(Integer id);

	//根据学生id查询学生资料


	//选课
	void saveCourse (Integer sid,Integer cid) throws MyException;

	//删除课程
	void deleteCourse (Integer sid,Integer cid);
	//查询选课
	Student findStudentCourse(Integer id);



	//查询所有学生（查看同班同学）

	//	注册学生账户
	void saveStudent(Student student) throws MyException;

	//    登录 存id到session
	Student findStudentByStuidAndPassowrd(Student student) throws MyException;

//查询一个学生信息
	Student findOneStudentById(Integer id);

	//更新学生信息
	void updateStudent(Student student) throws MyException;
//更新密码
    void editPasswordSubmit(Student student);

	void updateStudentFace(Student student);
}
