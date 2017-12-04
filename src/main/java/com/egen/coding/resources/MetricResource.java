package com.egen.coding.resources;

import java.util.IntSummaryStatistics;
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
		IntSummaryStatistics stats = datastore.createQuery(SensorData.class).asList().stream().mapToInt(value -> value.getValue()).summaryStatistics();
		if(sensorData.getValue()>stats.getAverage()*1.10 || sensorData.getValue()<stats.getAverage()*0.90) {
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
	public List<SensorData> readMetricByTimeRange(@RequestParam("startTime")Long startTime,
			@RequestParam("endTime")Long endTime) {
		return datastore.createQuery(SensorData.class).field("timeStamp").lessThan(endTime)
													.field("timeStamp").greaterThan(startTime).asList();
	}

}
