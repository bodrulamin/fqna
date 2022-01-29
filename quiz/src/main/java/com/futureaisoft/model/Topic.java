package com.futureaisoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topic")
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String createDaate;
	private String updateDate;
	
	public Topic() {
		
	}
	
	public Topic(long id, String name, String createDaate, String updateDate) {
		this.id = id;
		this.name = name;
		this.createDaate = createDaate;
		this.updateDate = updateDate;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreateDaate() {
		return createDaate;
	}
	public void setCreateDaate(String createDaate) {
		this.createDaate = createDaate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
