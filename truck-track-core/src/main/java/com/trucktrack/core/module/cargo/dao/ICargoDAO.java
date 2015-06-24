package com.trucktrack.core.module.cargo.dao;

import java.util.List;

import com.trucktrack.core.module.cargo.model.Cargo;

public interface ICargoDAO 
{
	
	public Cargo getCargo(String id);
	
	public List<Cargo> getCargos(String criteria);

	public Integer getCargosCount(String criteria);
	
	public List<Cargo> getCargosWithLimit(String criteria, Integer currentPage, Integer recordsPerPage);
	
	public void addCargo(Cargo cargo);
	
	public void updateCargo(Cargo cargo);
	
	public void deleteCargo(String id);
	
}
