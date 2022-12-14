package Models;

public class CouncilModel {
	private int id;
	private int topicId;
	private float AverageScore;
	public CouncilModel() {
		super();
	}
	
	public CouncilModel(int id, int topicId, float averageScore) {
		super();
		this.id = id;
		this.topicId = topicId;
		AverageScore = averageScore;
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
	public float getAverageScore() {
		return AverageScore;
	}
	public void setAverageScore(float averageScore) {
		AverageScore = averageScore;
	}
}
