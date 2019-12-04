package com.foodtruck.models.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Getter
public class TruckResponse {
	
	@JsonProperty("date")
	private String date;
	
	@JsonProperty("truck_names")
	private List<String> truckName;

	public void setDate(String date) {
		this.date = date;
	}

	public void setTruckName(List<String> truckName) {
		this.truckName = truckName;
	}
	
	

}
