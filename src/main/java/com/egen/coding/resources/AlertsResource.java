package com.egen.coding.resources;

import java.sql.Timestamp;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<SensorData> readAlertByTimeRange(@RequestParam("startTime")Timestamp startTime,
			@RequestParam("endTime")Timestamp endTime) {
		return datastore.createQuery(SensorData.class).field("alert").equal(true).field("recordTime").lessThan(endTime)
													.field("recordTime").greaterThan(startTime).asList();
	}

}
