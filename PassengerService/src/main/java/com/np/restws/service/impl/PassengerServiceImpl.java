package com.np.restws.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.stereotype.Service;

import com.np.restws.model.Passenger;
import com.np.restws.service.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService {
	
	private List<Passenger> passengers = new ArrayList<>();
	private static Long currentid = 103l;
	
	@Override
	public List<Passenger> getPassengers(int start, int size) {
		System.out.println(start);
		System.out.println(size);
		return passengers;
	}

	@Override
	public void addPassenger(String firstname, String lastname, String agent, HttpHeaders headers) {
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(agent);
		MultivaluedMap<String, String> multipleHeaders = headers.getRequestHeaders();
		Set<String> keySet = multipleHeaders.keySet();
		for (String key : keySet) {
			System.out.println(key);
			System.out.println(headers.getHeaderString(key));
		}
		Map<String, Cookie> cookies = headers.getCookies();
		Set<String> cookieKey = cookies.keySet();
		for (String key : cookieKey) {
			System.out.println("<----------------------cookie------------------------------->");
			System.out.println(key);
			System.out.println((cookies.get(key).getValue()));
		}
	}

	/*
	 * @Override public Passenger addPassenger(Passenger passenger) {
	 * passenger.setId(currentid++); passengers.add(passenger); return passenger; }
	 */
}
