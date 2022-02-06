package com.futureaisoft.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answerRating")
public class AnswerRating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private boolean isFavourite;
	private long answerId;
	private long userId;
	private Date createDate;
	private Date updateDate;

	public AnswerRating() {

	}

	public AnswerRating(long id, boolean isFavourite, long answerId, long userId, Date createDate,
						Date updateDate) {
		this.id = id;
		this.isFavourite = isFavourite;
		this.answerId = answerId;
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

	public boolean isFavourite() {
		return isFavourite;
	}

	public void setFavourite(boolean isFavoirite) {
		this.isFavourite = isFavoirite;
	}

	public long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(long answerId) {
		this.answerId = answerId;
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
