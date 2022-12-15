package Models;

public class TopicDetailsModel {
	private int id ;
	private int topicId;
	private int studentId;
	private Boolean leader;
	private float Scores;
	public TopicDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TopicDetailsModel(int id, int topicId, int studentId, Boolean leader, float scores) {
		super();
		this.id = id;
		this.topicId = topicId;
		this.studentId = studentId;
		this.leader = leader;
		Scores = scores;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
