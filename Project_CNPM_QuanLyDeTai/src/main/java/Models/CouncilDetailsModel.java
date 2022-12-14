package Models;

public class CouncilDetailsModel {
	private int id;
	private int CouncilId;
	private int teacherId;
	private Boolean leader;
	private float Scores;
	public CouncilDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CouncilDetailsModel(int id, int councilId, int teacherId, Boolean leader, float scores) {
		super();
		this.id = id;
		CouncilId = councilId;
		this.teacherId = teacherId;
		this.leader = leader;
		Scores = scores;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCouncilId() {
		return CouncilId;
	}
	public void setCouncilId(int councilId) {
		CouncilId = councilId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public Boolean getLeader() {
		return leader;
	}
	public void setLeader(Boolean leader) {
		this.leader = leader;
	}
	public float getScores() {
		return Scores;
	}
	public void setScores(float scores) {
		Scores = scores;
	}
	
}
