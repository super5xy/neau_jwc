package cn.ssm.service.impl;

import cn.ssm.dao.IStudentDao;
import cn.ssm.domain.Course;
import cn.ssm.domain.Student;
import cn.ssm.exception.MyException;
import cn.ssm.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements IStudentService {
	@Autowired
	IStudentDao studentDao;

	//查询所有课程，除了已选择的课程
	@Override
	public List<Course> findAllCourse(Integer id) {

		return studentDao.findAllCourse(id);
	}

	//	查询除了自己的信息
	@Override
	public List<Student> findAllStudent(Integer id) {
		return studentDao.findAllStudent(id);
	}

	//通过学生id和课程id选课 先查询，如果已经选了，不能再次选
	public void saveCourse(Integer sid, Integer cid) throws MyException {
		Student student = studentDao.findStudentCourse(sid);
		if (student != null) {
			List<Course> courses = student.getCourses();
			for (Course cours : courses) {

				if (cid == cours.getId()) {

					throw new MyException("已经选了这门课了");
				}
			}
		}

		studentDao.saveCourse(sid, cid);
	}

	//删除课程
	@Override
	public void deleteCourse(Integer sid, Integer cid) {
		studentDao.deleteCourse(sid, cid);
	}

	//查询已经选的课程     应该要判断是否null
	@Override
	public Student findStudentCourse(Integer id) {
		return studentDao.findStudentCourse(id);
	}


	//注册 注册之前执行查询学号，如果没有，则注册，如果有，抛出学号已注册异常
	@Override
	public void saveStudent(Student student) throws MyException {
		Student temp = new Student();
		temp.setStuid(student.getStuid());
		Student find = studentDao.findStudentByStuidAndPassowrd(temp);
		if (find != null) {
			throw new MyException("学号已经重复");
		}
		studentDao.saveStudent(student);
	}

	//登录 测试成功，调用会返回一个student，数据库的stuid为unique，只会返回一个student
	@Override
	public Student findStudentByStuidAndPassowrd(Student student) throws MyException {
		Student findstudent = studentDao.findStudentByStuidAndPassowrd(student);
//		if (findstudent==null){
//			throw new MyException("您未注册");
//		}
		return findstudent;
	}

	//查找一个学生资料，可以修改自己的资料，或者查看别人的资料
	@Override
	public Student findOneStudentById(Integer id) {
		return studentDao.findOneStudentById(id);
	}

	@Override
	public void updateStudent(Student student) throws MyException {

		Student temp = new Student();
		temp.setStuid(student.getStuid());
		Student find = studentDao.findStudentByStuidAndPassowrd(temp);
//		System.out.println(student);
//		System.out.println(find);
		//判断学号是否重复 并且如果和自己的学号一样正常更新

		//判断提交的学号，根据提交的学号查找，如果没有，正常更新
		if (find == null) {
			studentDao.updateStudent(student);
		}
		//如果有数据，判断是不是和自己的学号一样 我设置的提交的id是自己的id 所以通过id判断，
		if (find != null) {
			if (find.getId().equals(student.getId())) {
				studentDao.updateStudent(student);
			} else {
				throw new MyException("学号已经重复");
			}


		}
	}

	@Override
	public void editPasswordSubmit(Student student) {
		studentDao.updateStudentPassword(student);
	}
	@Override
	public void updateStudentFace(Student student) {

		studentDao.updateStudentFace(student);
	}
}
