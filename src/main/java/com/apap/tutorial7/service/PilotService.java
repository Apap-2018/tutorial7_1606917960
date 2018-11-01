package com.apap.tutorial7.service;

import com.apap.tutorial7.model.PilotModel;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial7.model.FlightModel;

public interface PilotService {
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	Optional<PilotModel> getPilotDetailById(long pilotId);
	List<FlightModel> getListFlightbyLicenseNumber(String licenseNumber);
	PilotModel addPilot(PilotModel pilot);
	void deletePilot(PilotModel pilot);
	void updatePilot(Long pilotId, PilotModel pilot);
}
