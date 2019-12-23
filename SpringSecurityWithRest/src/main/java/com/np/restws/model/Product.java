package com.np.restws.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	private Long id;
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
