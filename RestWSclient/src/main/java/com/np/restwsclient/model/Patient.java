package com.np.restwsclient.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Patient")
public class Patient {
	
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
