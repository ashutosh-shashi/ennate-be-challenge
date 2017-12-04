package com.egen.coding.resources;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.egen.coding.entity.SensorData;

@RestController
@RequestMapping("/alert")
public class AlertsResource {
	
	@Autowired
	private Datastore datastore;
		
	@RequestMapping(method = RequestMethod.GET, value = "/read")
	public List<SensorData> readAllAlert() {
		return datastore.createQuery(SensorData.class).field("alert").equal(true).asList();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/readByTimeRange")
	public List<SensorData> readAlertByTimeRange(@RequestParam("startTime")Long startTime,
			@RequestParam("endTime")Long endTime) {
		return datastore.createQuery(SensorData.class).field("alert").equal(true).field("timeStamp").lessThan(endTime)
													.field("timeStamp").greaterThan(startTime).asList();
	}

}
