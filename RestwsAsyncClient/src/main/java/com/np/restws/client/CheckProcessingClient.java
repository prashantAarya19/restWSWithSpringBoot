package com.np.restws.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.np.restws.model.CheckList;

public class CheckProcessingClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/restwsasyncprovider/services/checkprocessingservice/checks");
		AsyncInvoker invoker = target.request().async();
		Future<Boolean> response = invoker.post(Entity.entity(new CheckList(), MediaType.APPLICATION_XML),
				Boolean.class);
		try {
			System.out.println(response.get());
		} catch (InterruptedException | ExecutionException e) {
			if(e.getCause() instanceof BadRequestException)
				System.out.println("Plese send valid list of checks");
		}
	}// main

}// class
