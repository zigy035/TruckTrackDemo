package com.trucktrack.core.module.cargo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.trucktrack.core.common.dao.CommonDAO;
import com.trucktrack.core.module.cargo.dao.ICargoDAO;
import com.trucktrack.core.module.cargo.model.Cargo;

public class CargoDAO extends CommonDAO implements ICargoDAO
{

	@Override
	public Cargo getCargo(String id)
	{
		return (Cargo) getSqlMapClientTemplate().queryForObject("getCargo", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cargo> getCargos(String criteria)
	{
		return (List<Cargo>) getSqlMapClientTemplate().queryForList("getCargos", criteria);
	}
	
	@Override
	public Integer getCargosCount(String criteria)
	{
		return (Integer) getSqlMapClientTemplate().queryForObject("getCargosCount", criteria);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cargo> getCargosWithLimit(String criteria, Integer currentPage, Integer recordsPerPage)
	{
		int offset = (currentPage - 1) * recordsPerPage;
		String limit = " LIMIT " + offset + ", " + recordsPerPage;
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("criteria", criteria);
		params.put("limit", limit);
		
		return (List<Cargo>) getSqlMapClientTemplate().queryForList("getCargosWithLimit", params);
	}

	@Override
	public void addCargo(Cargo cargo)
	{
		getSqlMapClientTemplate().insert("addCargo", cargo);
	}
	
	@Override
	public void updateCargo(Cargo cargo)
	{
		getSqlMapClientTemplate().update("updateCargo", cargo);
	}

	@Override
	public void deleteCargo(String id)
	{
		getSqlMapClientTemplate().delete("deleteCargo", id);
	}

}
