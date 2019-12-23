package com.np.restws.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.np.restws.model.Patient;
import com.np.restws.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	Map<Long, Patient> patients = new HashMap<>();
	long id = 123;
	
	public PatientServiceImpl() {
		init();
	}

	private void init() {
		Patient patient = new Patient();
		patient.setId(id);
		patient.setName("Hameem");
		patients.put(patient.getId(), patient);
	}

	@Override
	public List<Patient> getPatients() {
		Collection<Patient> results = patients.values();
		List<Patient> response = new ArrayList<>(results);
		return response;
	}

	@Override
	public Patient getPatient(Long id) {
		/*
		 * if(patients.get(id) == null) { throw new
		 * WebApplicationException(Response.Status.FORBIDDEN); }
		 */
		return patients.get(id);
	}

	@Override
	public Response addPatient(Patient patient) {
		
		  //if(patient.getId()==null) { throw new PatientBusinessException(); }
		 
		patient.setId(++id);
		patients.put(patient.getId(), patient);
		return Response.ok(patient).build();
	}

	@Override
	public Response updatePatient(Patient patient) {
		Patient currentPatient = patients.get(patient.getId());
		Response response;
		if(currentPatient!=null) {
			patients.put(patient.getId(), patient);
			response = Response.ok().build();
		}
		else {
			//response = Response.notModified().build();
			throw new PatientBusinessException();
		}
		return response;
	}

	@Override
	public Response deletePatient(Long id) {
		Patient patient = patients.get(id);
		Response response;
		if(patient.getId().equals(id)) {
			patients.remove(id);
			response = Response.ok().build();
		}
		else {
			response = Response.notModified().build();
		}
		return response;
	}

	
}
