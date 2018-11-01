package com.apap.tutorial7.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.repository.FlightDB;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDB flightDb;
	
	@Override
	public FlightModel addFlight(FlightModel flight) {
		return flightDb.save(flight);
	}

	@Override
	public void deleteFlight(FlightModel flight) {
		flightDb.delete(flight);
	}

	@Override
	public void updateFlight(long flightId, FlightModel flight) {
		FlightModel updateFlight = flightDb.getOne(flightId);
		updateFlight.setDestination(flight.getDestination());
		updateFlight.setOrigin(flight.getOrigin());
		updateFlight.setTime(flight.getTime());
		flightDb.save(updateFlight);
		
	}

	@Override
	public FlightModel getFlightDetailById(long Id) {
		// TODO Auto-generated method stub
		return flightDb.findById(Id);
	}

	@Override
	public void deleteFlightById(long Id) {
		// TODO Auto-generated method stub
		flightDb.deleteById(Id);
	}

	@Override
	public List<FlightModel> getAllFlight() {
		// TODO Auto-generated method stub
		return flightDb.findAll();
	}
	
	
}
