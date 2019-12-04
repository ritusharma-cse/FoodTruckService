package com.foodtruck.db.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.foodtruck.models.db.TruckScheduleDbEntity;

@EnableScan
public interface TruckScheduleRepository extends CrudRepository<TruckScheduleDbEntity, Long> {

}
