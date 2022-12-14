package Models;

import java.util.Date;

public class SignUpModel {
	private int signUpId;
	private Date startTime;
	private Date endTime;
	private boolean role;
	public SignUpModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SignUpModel(int signUpId, Date startTime, Date endTime, boolean role) {
		super();
		this.signUpId = signUpId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.role = role;
	}
	public int getSignUpId() {
		return signUpId;
	}
	public void setSignUpId(int signUpId) {
		this.signUpId = signUpId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public boolean isRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
	
	
}
