package com.trucktrack.core.module.vehicle.dao;

import java.util.List;

import com.trucktrack.core.module.vehicle.model.Vehicle;

public interface IVehicleDAO
{
	Vehicle getVehicle(String id);

	List<Vehicle> getVehicles(String criteria);

	void add(Vehicle vehicle);

	void update(Vehicle vehicle);

	void delete(Vehicle vehicle);
}
