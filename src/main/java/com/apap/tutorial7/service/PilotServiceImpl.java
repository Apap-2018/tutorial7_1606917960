package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.model.PilotModel;
import com.apap.tutorial7.repository.FlightDB;
import com.apap.tutorial7.repository.PilotDB;

@Service
@Transactional
public class PilotServiceImpl implements PilotService {
	@Autowired
	private PilotDB pilotDb;
	
	@Autowired
	private FlightDB flightDb;
	
	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}
	
	@Override
	public PilotModel addPilot(PilotModel pilot) {
		return pilotDb.save(pilot);
	}

	@Override
	public void deletePilot(PilotModel pilot) {
		// TODO Auto-generated method stub
		pilotDb.delete(pilot);
	}

	@Override
	public void updatePilot(Long idPIlot, PilotModel pilot) {
		PilotModel updatePilot = pilotDb.getOne(idPIlot);
		updatePilot.setName(pilot.getName());
		updatePilot.setFlyHour(pilot.getFlyHour());
		pilotDb.save(updatePilot);
	}

	@Override
	public List<FlightModel> getListFlightbyLicenseNumber(String licenseNumber) {
		// TODO Auto-generated method stub
		return flightDb.findByPilotLicenseNumber(licenseNumber);
	}

	@Override
	public Optional<PilotModel> getPilotDetailById(long pilotId) {
		// TODO Auto-generated method stub
		return pilotDb.findById(pilotId);
	}
	
	
}
