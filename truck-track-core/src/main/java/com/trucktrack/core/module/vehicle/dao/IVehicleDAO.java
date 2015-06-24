package com.trucktrack.core.module.vehicle.dao;

import java.util.List;

import com.trucktrack.core.module.vehicle.model.Vehicle;

public interface IVehicleDAO
{
	Vehicle getProjectById(long id);

	List<Vehicle> getAllProjects();

	Long insert(Vehicle vehicle);

	void update(Vehicle vehicle);

	void delete(Vehicle vehicle);
}
