package com.np.restws.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.np.restws.model.Patient;

@Consumes("application/xml, application/json")
@Produces("application/xml, application/json")
@Path("/patientservice")
public interface PatientService {

		@Path("/patients")
		@GET
		public List<Patient> getPatients();
		
		@Path("/patient/{id}")
		@GET
		public Patient getPatient(@PathParam(value = "id") Long id);
		
		@Path("/patient")
		@POST
		public Response addPatient(Patient patient);
		
		@Path("/patient")
		@PUT
		public Response updatePatient(Patient patient);
		
		@Path("/patient/{id}")
		@DELETE
		public Response deletePatient(@PathParam(value = "id") Long id);
}
