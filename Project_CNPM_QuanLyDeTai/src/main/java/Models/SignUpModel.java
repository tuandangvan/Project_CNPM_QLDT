package Models;

import java.sql.Date;


public class SignUpModel {
	private int signUpId;
	private Date startTime;
	private Date endTime;
	private Boolean role;
	
	private int yStart;
	private int mStart;
	private int dStart;
	
	private int yEnd;
	private int mEnd;
	private int dEnd;

	public SignUpModel() {
		super();
	}

	public SignUpModel(int signUpId, Date startTime, Date endTime, boolean role) {
		super();
		this.signUpId = signUpId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.role = role;
	}
	
	public SignUpModel(int signUpId, Date startTime, Date endTime, Boolean role, int yStart, int mStart, int dStart,
			int yEnd, int mEnd, int dEnd) {
		super();
		this.signUpId = signUpId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.role = role;
		this.yStart = yStart;
		this.mStart = mStart;
		this.dStart = dStart;
		this.yEnd = yEnd;
		this.mEnd = mEnd;
		this.dEnd = dEnd;
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
