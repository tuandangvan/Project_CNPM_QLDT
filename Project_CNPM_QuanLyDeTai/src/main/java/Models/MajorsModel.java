package Models;

public class MajorsModel {
	private int majorId;
	private String majorName;
	public MajorsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MajorsModel(int majorId, String majorName) {
		super();
		this.majorId = majorId;
		this.majorName = majorName;
	}
	public int getMajorId() {
		return majorId;
	}
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	
}
