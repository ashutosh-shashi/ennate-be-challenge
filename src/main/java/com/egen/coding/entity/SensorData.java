package com.egen.coding.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("SensorData")
public class SensorData {
	@Id
	private ObjectId id;
	Integer value;
	Long timeStamp;
	Boolean alert;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Boolean getAlert() {
		return alert;
	}

	public void setAlert(Boolean alert) {
		this.alert = alert;
	}

	public SensorData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SensorData(Integer value, Long timeStamp, Boolean alert) {
		super();
		this.value = value;
		this.timeStamp = timeStamp;
		this.alert = alert;
	}

	@Override
	public String toString() {
		return "SensorData [value=" + value + ", timeStamp=" + timeStamp + ", alert=" + alert + "]";
	}



}
