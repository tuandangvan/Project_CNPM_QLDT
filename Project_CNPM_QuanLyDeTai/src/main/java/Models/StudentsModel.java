package Models;

import java.sql.Date;

public class StudentsModel {
	private int studentId;
	private String studentName;
	private Boolean gender;
	private Date birth;
	private String email;
	private String phone;
	private String address;
	private int majorId;
	public StudentsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentsModel(int studentId, String studentName, Boolean gender, Date birth, String email, String phone,
			String address, int majorId) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.majorId = majorId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMajorId() {
		return majorId;
	}
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
}
