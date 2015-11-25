package com.trucktrack.core.module.vehicle.model;

import java.util.Date;
import java.util.UUID;

public class Vehicle
{
	private String id;
	private Date published;
	private Date deadline;
	private String refCountryCodeFrom;
	private String cityFrom;
	private String postCodeFrom;
	private String refCountryCodeTo;
	private String cityTo;
	private String postCodeTo;
	private Double dimLength;
	private Double dimWeight;
	private Integer vehicleType;
	private String refCustomerId;
	
	public Vehicle()
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
	public Integer getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(Integer vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getRefCustomerId() {
		return refCustomerId;
	}
	public void setRefCustomerId(String refCustomerId) {
		this.refCustomerId = refCustomerId;
	}

	@Override
	public String toString() {
		return "Vehicle [published=" + published + ", deadline=" + deadline
				+ ", refCountryCodeFrom=" + refCountryCodeFrom + ", cityFrom="
				+ cityFrom + ", postCodeFrom=" + postCodeFrom
				+ ", refCountryCodeTo=" + refCountryCodeTo + ", cityTo="
				+ cityTo + ", postCodeTo=" + postCodeTo + ", dimLength="
				+ dimLength + ", dimWeight=" + dimWeight + ", vehicleType=" + vehicleType
				+ "]";
	}
}
