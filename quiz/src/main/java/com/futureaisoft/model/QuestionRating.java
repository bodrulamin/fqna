package com.futureaisoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questionRating")
public class QuestionRating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private boolean isFavoirite;
	private long questionId;
	private long userId;
	private String createDate;
	private String updateDate;

	public QuestionRating() {

	}

	public QuestionRating(long id, boolean isFavoirite, long questionId, long userId, String createDate,
			String updateDate) {
		this.id = id;
		this.isFavoirite = isFavoirite;
		this.questionId = questionId;
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

	public boolean isFavoirite() {
		return isFavoirite;
	}

	public void setFavoirite(boolean isFavoirite) {
		this.isFavoirite = isFavoirite;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
}
