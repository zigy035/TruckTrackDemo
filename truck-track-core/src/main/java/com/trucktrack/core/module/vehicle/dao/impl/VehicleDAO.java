package com.trucktrack.core.module.vehicle.dao.impl;

import java.util.List;

import com.trucktrack.core.common.dao.CommonDAO;
import com.trucktrack.core.module.vehicle.dao.IVehicleDAO;
import com.trucktrack.core.module.vehicle.model.Vehicle;

public class VehicleDAO extends CommonDAO implements IVehicleDAO
{

	@Override
	public Vehicle getVehicle(String id) {
		return (Vehicle) getSqlMapClientTemplate().queryForObject("getVehicle", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> getVehicles(String criteria) {
		return (List<Vehicle>) getSqlMapClientTemplate().queryForList("getVehicles", criteria);
	}

	@Override
	public void add(Vehicle vehicle) {
		getSqlMapClientTemplate().insert("addVehicle", vehicle);
	}

	@Override
	public void update(Vehicle vehicle) {
		getSqlMapClientTemplate().update("updateVehicle", vehicle);
	}

	@Override
	public void delete(Vehicle vehicle) {
		getSqlMapClientTemplate().delete("deleteVehicle", vehicle);
	}

}
