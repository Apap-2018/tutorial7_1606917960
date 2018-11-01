package com.apap.tutorial7.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.rest.Setting;
import com.apap.tutorial7.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@PostMapping(value="/add")
	public FlightModel addFlightSubmit(@RequestBody FlightModel flight) {
		return flightService.addFlight(flight);
	}
	
	@GetMapping(value="/view/{flightId}")
	public FlightModel flightView(@PathVariable("flightId") long flightId) {
		FlightModel flight = flightService.getFlightDetailById(flightId);
		return flight;
	}
	
	@GetMapping(value="/all")
	public List<FlightModel> flightAll() {
		return flightService.getAllFlight();
	}
	
	@DeleteMapping(value="/delete/{flightId}")
	public String deleteFlight(@PathVariable("flightId") long flightId) {
		FlightModel flight = flightService.getFlightDetailById(flightId);
		flightService.deleteFlight(flight);
		return "flight has been deleted";
	}
	
	@PutMapping(value="/update/{flightId}")
	public String updatePilotSubmit(@PathVariable("flightId") long flightId, 
			@RequestParam(value="destination", required=false) Optional<String> destination,
			@RequestParam(value="origin", required=false) Optional<String> origin,
			@RequestParam(value="time", required=false) Optional<Date> time) {
		FlightModel flight = flightService.getFlightDetailById(flightId);
		if (flight.equals(null)) {
			return "Couldn't find your flight";
		}
		if (destination.isPresent()) {
			flight.setDestination(destination.get());
		}
		if (origin.isPresent()) {
			flight.setOrigin(origin.get());
		}
		if (time.isPresent()) {
			flight.setTime(time.get());
		}
		flightService.updateFlight(flightId, flight);

		return "update";
	}		
}
