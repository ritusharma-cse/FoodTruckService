package com.foodtruck.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodtruck.db.repository.TruckScheduleRepository;
import com.foodtruck.models.db.TruckScheduleDbEntity;
import com.foodtruck.models.response.TruckListAddRequest;
import com.foodtruck.models.response.TruckResponse;

@RestController
@RequestMapping("/foodtruck")
public class TruckController {
	
	private final TruckScheduleRepository truckScheduleRepository;
	
	@Autowired
	public TruckController(TruckScheduleRepository truckScheduleRepository) {
		this.truckScheduleRepository = truckScheduleRepository;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{date}")
	@ResponseBody
	public TruckResponse getTrucks(@PathVariable(value = "date") String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Long epoch = formatter.parse(date).getTime();
		
		// fetch db entity
		TruckScheduleDbEntity dbEntity = truckScheduleRepository.findById(epoch).get();
		
		
		// create and return response
		TruckResponse response = new TruckResponse();
		response.setDate(date);
		response.setTruckName(dbEntity.getTruckNames());
		
		return response;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/")
	public void updateTrucks(@RequestBody TruckListAddRequest addRequest) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Long epoch = formatter.parse(addRequest.getDate()).getTime();
		
		// create db entity
		TruckScheduleDbEntity dbEntity = new TruckScheduleDbEntity();
		dbEntity.setScheduleDate(epoch);
		dbEntity.setTruckNames(addRequest.getTruckNames());
		
		// save db entity
		truckScheduleRepository.save(dbEntity);
	}

}
