package Models;

import java.sql.Date;

public class TopicModel {
	private int topicId;
	
	private String topicName;
	
	private int teacherId;
	
	private String detail;
	private Date createAt;
	private String link;
	
	
	//
	private int quantityRegister;

	public TopicModel(int topicId, String topicName, int teacherId, String detail, Date createAt) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
		this.teacherId = teacherId;
		this.detail = detail;
		this.createAt=createAt;
	}
	public TopicModel(int topicId, String topicName, int teacherId, String detail, Date createAt, String link) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
		this.teacherId = teacherId;
		this.detail = detail;
		this.createAt = createAt;
		this.link = link;
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

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getQuantityRegister() {
		return quantityRegister;
	}

	public void setQuantityRegister(int quantityRegister) {
		this.quantityRegister = quantityRegister;
	}
	
	
}


	
	
	
	
	