package com.trucktrack.web.bean;

public class CargoSearchBean
{
	private String countryCodeFrom;
	private String countryCodeTo;
	
	public CargoSearchBean()
	{
		this.countryCodeFrom = "";
		this.countryCodeTo = "";
	}
	
	public String getCountryCodeFrom() {
		return countryCodeFrom;
	}
	public void setCountryCodeFrom(String countryCodeFrom) {
		this.countryCodeFrom = countryCodeFrom;
	}
	public String getCountryCodeTo() {
		return countryCodeTo;
	}
	public void setCountryCodeTo(String countryCodeTo) {
		this.countryCodeTo = countryCodeTo;
	}
	
}
