package com.apap.tutorial7.service;

import java.util.List;

import com.apap.tutorial7.model.FlightModel;

public interface FlightService {
	FlightModel addFlight(FlightModel pilot);
	void deleteFlight(FlightModel flight);
	void updateFlight(long flightId, FlightModel flight);
	void deleteFlightById(long Id);
	List<FlightModel> getAllFlight();
	FlightModel getFlightDetailById(long Id);
}
