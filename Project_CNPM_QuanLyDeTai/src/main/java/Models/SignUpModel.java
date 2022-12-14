package Models;

import java.sql.Date;
import java.sql.Timestamp;

public class SignUpModel {
	private int signUpId;
	private Timestamp startTime;
	private Timestamp endTime;
	private Boolean role;
	
	private int yStart;
	private int mStart;
	private int dStart;
	
	private int yEnd;
	private int mEnd;
	private int dEnd;
	
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
	public int getyStart() {
		return yStart;
	}
	public void setyStart(int yStart) {
		this.yStart = yStart;
	}
	public int getmStart() {
		return mStart;
	}
	public void setmStart(int mStart) {
		this.mStart = mStart;
	}
	public int getdStart() {
		return dStart;
	}
	public void setdStart(int dStart) {
		this.dStart = dStart;
	}
	public int getyEnd() {
		return yEnd;
	}
	public void setyEnd(int yEnd) {
		this.yEnd = yEnd;
	}
	public int getmEnd() {
		return mEnd;
	}
	public void setmEnd(int mEnd) {
		this.mEnd = mEnd;
	}
	public int getdEnd() {
		return dEnd;
	}
	public void setdEnd(int dEnd) {
		this.dEnd = dEnd;
	}

	
	
}
