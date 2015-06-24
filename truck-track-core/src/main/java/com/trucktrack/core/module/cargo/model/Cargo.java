package com.trucktrack.core.module.cargo.model;

import java.util.Date;
import java.util.UUID;

public class Cargo
{
	private String id;
	private Date published;
	private Date deadline;
	private String refCountryCodeFrom;
	private String addressFrom;
	private String cityFrom;
	private String postcodeFrom;
	private String refCountryCodeTo;
	private String addressTo;
	private String cityTo;
	private String postcodeTo;
	private Double dimLength;
	private Double dimWeight;
	private String type;
	
	public Cargo()
	{
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
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

	public String getPostcodeTo() {
		return postcodeTo;
	}

	public void setPostcodeTo(String postcodeTo) {
		this.postcodeTo = postcodeTo;
	}

	public Double getDimLength() {
		return dimLength;
	}

	public void setDimLength(Double dimLength) {
		this.dimLength = dimLength;
	}

	public Double getDimWeight() {
		return dimWeight;
	}

	public void setDimWeight(Double dimWeight) {
		this.dimWeight = dimWeight;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
