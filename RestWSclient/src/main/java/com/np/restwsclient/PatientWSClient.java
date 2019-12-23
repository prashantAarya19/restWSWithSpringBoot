package com.np.restwsclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.np.restwsclient.model.Patient;

public class PatientWSClient {

	private static final String PATIENT = "/patient";
	private static final String PATIENTSERVICE_URL = "http://localhost:8080/restws/services/patientservice";

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();

		// for retrieving data
		WebTarget target = client.target(PATIENTSERVICE_URL).path(PATIENT).path("/{id}");
		target = target.resolveTemplate("id", 123);
		Builder request = target.request();
		Patient patient = request.get(Patient.class);
		System.out.println(patient.getId());
		System.out.println(patient.getName()); 

		patient.setName("Ravi");
		// for updating data
		WebTarget putTarget = client.target(PATIENTSERVICE_URL).path(PATIENT);
		Response updateResponse = putTarget.request().put(Entity.entity(patient, MediaType.APPLICATION_XML));
		System.out.println(updateResponse.getStatus());
		updateResponse.close(); 
		
		//for adding data
		Patient newPatient = new Patient();
		newPatient.setName("Bob");
		WebTarget postTarget = client.target(PATIENTSERVICE_URL).path(PATIENT);
		Patient createdPatient = postTarget.request().post(Entity.entity(newPatient, MediaType.APPLICATION_XML),
				Patient.class);
		System.out.println("Added patient::" + createdPatient.getId()+" patient name:::"+createdPatient.getName());
		
		//for deleting patient
		WebTarget delTarget = client.target(PATIENTSERVICE_URL).path(PATIENT).path("/{id}").resolveTemplate("id", 124);
		Builder delBuilder = delTarget.request();
		Response resp = delBuilder.delete();
		System.out.println("Deleted:::"+resp.getStatus());
		client.close();
	}

}
