package com.trucktrack.web.model;

import java.util.UUID;


public class CargoView
{
	private String id;
	private String published;
	private String deadline;
	private String refCountryCodeFrom;
	private String addressFrom;
	private String cityFrom;
	private String postcodeFrom;
	private String refCountryCodeTo;
	private String addressTo;
	private String cityTo;
	private String postCodeTo;
	private String dimLength;
	private String dimWeight;
	private String type;
	
	public CargoView()
	{
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getAddressFrom() {
		return addressFrom;
	}

	public void setAddressFrom(String addressFrom) {
		this.addressFrom = addressFrom;
	}

	public String getCityFrom() {
		return cityFrom;
	}

	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}

	public String getPostcodeFrom() {
		return postcodeFrom;
	}

	public void setPostcodeFrom(String postcodeFrom) {
		this.postcodeFrom = postcodeFrom;
	}

	public String getRefCountryCodeTo() {
		return refCountryCodeTo;
	}

	public void setRefCountryCodeTo(String refCountryCodeTo) {
		this.refCountryCodeTo = refCountryCodeTo;
	}

	public String getAddressTo() {
		return addressTo;
	}

	public void setAddressTo(String addressTo) {
		this.addressTo = addressTo;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
