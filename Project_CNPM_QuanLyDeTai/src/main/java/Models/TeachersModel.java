package Models;

import java.sql.Date;

public class TeachersModel {
	private int teacherId;
	private String teacherName;
	private Boolean gender;
	private Date birth;
	private String email;
	private String phone;
	private int majorId;
	public TeachersModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TeachersModel(int teacherId, String teacherName, Boolean gender, Date birth, String email, String phone,
			int majorId) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.phone = phone;
		this.majorId = majorId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getMajorId() {
		return majorId;
	}
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
	
	
	
	
}
