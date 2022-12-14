package Models;

import java.sql.Date;

public class AdminsModel {
	private int adminId;
	private String adminName;
	private Boolean gender;
	private Date birth;
	private String email;
	private String phone;
	public AdminsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminsModel(int adminId, String adminName, Boolean gender, Date birth, String email, String phone) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.phone = phone;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
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
		
	
}
