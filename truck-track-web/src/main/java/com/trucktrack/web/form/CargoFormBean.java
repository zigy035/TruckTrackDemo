package com.trucktrack.web.form;

public class CargoFormBean {
	
	private String published;
	private String deadline;
	private String refCountryCodeFrom;
	private String cityFrom;
	private String postCodeFrom;
	private String refCountryCodeTo;
	private String cityTo;
	private String postCodeTo;
	private String dimLength;
	private String dimWeight;
	private Integer type;
	
	public String getPublished() {
		return published;
	}
	public void setPublished(String published) {
		this.published = published;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getRefCountryCodeFrom() {
		return refCountryCodeFrom;
	}
	public void setRefCountryCodeFrom(String refCountryCodeFrom) {
		this.refCountryCodeFrom = refCountryCodeFrom;
	}
	public String getCityFrom() {
		return cityFrom;
	}
	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}
	public String getPostCodeFrom() {
		return postCodeFrom;
	}
	public void setPostCodeFrom(String postCodeFrom) {
		this.postCodeFrom = postCodeFrom;
	}
	public String getRefCountryCodeTo() {
		return refCountryCodeTo;
	}
	public void setRefCountryCodeTo(String refCountryCodeTo) {
		this.refCountryCodeTo = refCountryCodeTo;
	}
	public String getCityTo() {
		return cityTo;
	}
	public void setCityTo(String cityTo) {
		this.cityTo = cityTo;
	}
	public String getPostCodeTo() {
		return postCodeTo;
	}
	public void setPostCodeTo(String postCodeTo) {
		this.postCodeTo = postCodeTo;
	}
	public String getDimLength() {
		return dimLength;
	}
	public void setDimLength(String dimLength) {
		this.dimLength = dimLength;
	}
	public String getDimWeight() {
		return dimWeight;
	}
	public void setDimWeight(String dimWeight) {
		this.dimWeight = dimWeight;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
}
