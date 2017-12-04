package com.egen.coding.entity;

import java.sql.Timestamp;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity("SensorData")
public class SensorData {
	@Id
	private ObjectId id;
	String name;
	Integer personId;
	Integer weight;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
	Timestamp recordTime;
	Boolean alert;
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public Timestamp getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}

	public Boolean getAlert() {
		return alert;
	}
	public void setAlert(Boolean alert) {
		this.alert = alert;
	}
	@Override
	public String toString() {
		return "SensorData [weight=" + weight + ", name=" + name + ", personId=" + personId + ", recordTime="
				+ recordTime + "]";
	}
	public SensorData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SensorData(Integer weight, String name, Integer personId, Timestamp recordTime) {
		super();
		this.weight = weight;
		this.name = name;
		this.personId = personId;
		this.recordTime = recordTime;
	}


}
