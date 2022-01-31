package com.futureaisoft.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String question;
	private String type;
	private String imageUrl;
	private long topicId;
	private long userId;
	private Date createDate;
	private Date updateDate;
		
	public Question() {
	
	}
	
	public Question(long id, String question, String type, String imageUrl, long topicId, long userId,
			Date createDate, Date updateDate) {
		this.id = id;
		this.question = question;
		this.type = type;
		this.imageUrl = imageUrl;
		this.topicId = topicId;
		this.userId = userId;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public long getTopicId() {
		return topicId;
	}
	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Question{" +
				"id=" + id +
				", question='" + question + '\'' +
				", type='" + type + '\'' +
				", imageUrl='" + imageUrl + '\'' +
				", topicId=" + topicId +
				", userId=" + userId +
				", createDate='" + createDate + '\'' +
				", updateDate='" + updateDate + '\'' +
				'}';
	}
}