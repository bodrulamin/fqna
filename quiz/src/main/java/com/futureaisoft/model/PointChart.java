package com.futureaisoft.model;

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
	private String createDate;
	private String updateDate;
	
	public PointChart() {

	}
	
	public PointChart(long id, int questionPoint, int answerPoint, String createDate, String updateDate) {
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
