package Models;

public class TopicModel {
	private int topicId;
	
	private String topicName;
	
	private int teacherId;
	
	private String detail;

	public TopicModel(int topicId, String topicName, int teacherId, String detail) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
		this.teacherId = teacherId;
		this.detail = detail;
	}

	public TopicModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}


	
	
	
	
	