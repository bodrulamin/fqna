package com.futureaisoft.model;

public class PointChart {

	private long id;
	private int questionPoint;
	private int answerPoint;
	private String createDate;
	private String updateDate;
	
	
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
