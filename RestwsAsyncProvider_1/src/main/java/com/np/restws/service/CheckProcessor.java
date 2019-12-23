package com.np.restws.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

import com.np.restws.model.CheckList;

@Path("/checkprocessingservice")
public interface CheckProcessor {
	
	@POST
	@Path("/checks")
	public void processCheck(@Suspended AsyncResponse response, CheckList checkList);
}
