package com.futureaisoft.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pointChart")
public class PointChart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int questionPoint;
	private int answerPoint;
	private Date createDate;
	private Date updateDate;
	
	public PointChart() {

	}
	
	public PointChart(long id, int questionPoint, int answerPoint, Date createDate, Date updateDate) {
		this.id = id;
		this.questionPoint = questionPoint;
		this.answerPoint = answerPoint;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuestionPoint() {
		return questionPoint;
	}
	public void setQuestionPoint(int questionPoint) {
		this.questionPoint = questionPoint;
	}
	public int getAnswerPoint() {
		return answerPoint;
	}
	public void setAnswerPoint(int answerPoint) {
		this.answerPoint = answerPoint;
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
