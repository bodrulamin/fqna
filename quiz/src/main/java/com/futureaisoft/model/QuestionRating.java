package com.futureaisoft.model;

import java.sql.Date;

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
	private Date createDate;
	private Date updateDate;

	public QuestionRating() {

	}

	public QuestionRating(long id, boolean isFavoirite, long questionId, long userId, Date createDate,
			Date updateDate) {
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


}
