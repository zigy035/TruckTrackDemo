package com.trucktrack.core.module.geolocation.model;

import java.util.UUID;

public class City {
	
	private String id;
	private String name;
	private String postcode;
	private Boolean allowed;
	private String refCountryCode;
	
	public City() {
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public Boolean getAllowed() {
		return allowed;
	}
	public void setAllowed(Boolean allowed) {
		this.allowed = allowed;
	}
	public String getRefCountryCode() {
		return refCountryCode;
	}
	public void setRefCountryCode(String refCountryCode) {
		this.refCountryCode = refCountryCode;
	}
	
}
