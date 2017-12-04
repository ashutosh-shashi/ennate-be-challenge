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
@RequestMapping("/matric")
public class MetricResource {
	
	@Autowired
	private Datastore datastore;
	
	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public void createMetric(@RequestBody SensorData sensorData) {
		if(sensorData.getWeight()>150 || sensorData.getWeight()<100) {
			sensorData.setAlert(true);
		}else {
			sensorData.setAlert(false);
		}
		datastore.save(sensorData);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/read")
	public List<SensorData> readAllMetric() {
		return datastore.createQuery(SensorData.class).asList();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/readByTimeRange")
	public List<SensorData> readMetricByTimeRange(@RequestParam("startTime")Timestamp startTime,
			@RequestParam("endTime")Timestamp endTime) {
		return datastore.createQuery(SensorData.class).field("recordTime").lessThan(endTime)
													.field("recordTime").greaterThan(startTime).asList();
	}

}
