package com.foodtruck.models.db;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "TruckSchedule")
public class TruckScheduleDbEntity {

	private List<String> truckNames;
	private Long scheduleDate;

	@DynamoDBAttribute(attributeName = "truck_names")
	public List<String> getTruckNames() {
		return truckNames;
	}

	@DynamoDBHashKey(attributeName = "schedule_date")
	public Long getScheduleDate() {
		return scheduleDate;
	}

	public void setTruckNames(List<String> truckNames) {
		this.truckNames = truckNames;
	}

	public void setScheduleDate(Long scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	
	

}
