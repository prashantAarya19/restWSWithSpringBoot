package com.np.restws.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.np.restws.model.Passenger;

@Path("/passengerservice")
@Produces("application/xml")
@Consumes("application/xml, application/x-www-form-urlencoded")
public interface PassengerService {
	
	@Path("/passengers")
	@GET
	public List<Passenger> getPassengers(@QueryParam("start")int start, @QueryParam("size")int size); 
	/*
	 * @Path("/passenger")
	 * 
	 * @POST public Passenger addPassenger(Passenger passenger);
	 */
	@Path("/passenger")
	@POST
	public void addPassenger(@FormParam("firstname")String firstname, @FormParam("lastname")String lastname, @HeaderParam("agent")String agent, @Context HttpHeaders headers);
}

