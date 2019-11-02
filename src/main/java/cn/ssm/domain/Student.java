package cn.ssm.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Student implements Serializable {
	//数据库id
	private Integer id;
	//学号
	private String stuid;
	//名字
	private String name;
	//密码
	private String password;

	private String gender;

	private Date birthday;
	//个性签名
	private String sign;
	private List<Course> courses;
	//头像文件名称
	private String filename;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", stuid='" + stuid + '\'' +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", gender='" + gender + '\'' +
				", birthday=" + birthday +
				", sign='" + sign + '\'' +
				", courses=" + courses +
				", filename='" + filename + '\'' +
				'}';
	}
}

