package com.foodtruck.models.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class TruckListAddRequest {

	@JsonProperty("date")
	private String date;

	@JsonProperty("truck_names")
	private List<String> truckNames;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<String> getTruckNames() {
		return truckNames;
	}

	public void setTruckNames(List<String> truckNames) {
		this.truckNames = truckNames;
	}
	
	

}
