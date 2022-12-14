package Models;

import java.sql.Date;
import java.sql.Timestamp;

public class SignUpModel {
	private int signUpId;
	private Timestamp startTime;
	private Timestamp endTime;
	private Boolean role;
	public SignUpModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SignUpModel(int signUpId, Timestamp startTime, Timestamp endTime, Boolean role) {
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
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public Boolean getRole() {
		return role;
	}
	public void setRole(Boolean role) {
		this.role = role;
	}
	
	
}
