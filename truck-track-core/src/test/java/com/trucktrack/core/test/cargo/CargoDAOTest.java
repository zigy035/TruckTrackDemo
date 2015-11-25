package com.trucktrack.core.test.cargo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.trucktrack.core.module.cargo.dao.ICargoDAO;
import com.trucktrack.core.module.cargo.model.Cargo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:com/trucktrack/core/test/applicationContext-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class CargoDAOTest extends AbstractTransactionalJUnit4SpringContextTests
{
	private static final String DEADLINE = "2012-12-12";
	private static final Double DIM_LENGTH = 14.5;
	private static final Double DIM_WEIGHT= 2.4;
	private static final Integer TYPE = 1;
	public static final String OBJECT_ID = "uniqueObjectId";
	public static final String NEW = "New";
	public static final String UPDATED = "Updated";

	
	public Date parseDate(String strDate)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			return dateFormat.parse(strDate);
		}
		catch (Exception e)
		{
			return new Date();
		}
	}
	
	@Autowired
	private ICargoDAO cargoDAO;
	
	private Cargo cargo;
	
	@Before
	public void before()
	{		
		cargo = new Cargo();
		cargo.setId(OBJECT_ID);
		cargo.setDeadline(parseDate(DEADLINE));
		cargo.setRefCountryCodeFrom("RS");
		cargo.setRefCountryCodeTo("AT");
		cargo.setCityFrom("Belgrade");
		cargo.setCityTo("Wien");
		cargo.setPostCodeFrom("11000");
		cargo.setPostCodeTo("41500");
		cargo.setDimLength(DIM_LENGTH);
		cargo.setDimWeight(DIM_WEIGHT);
		cargo.setVehicleType(TYPE);
		
		cargoDAO.addCargo(cargo);
	}
	
	
	@Test
	public void testGetCargo()
	{
		Cargo cargo = cargoDAO.getCargo(OBJECT_ID);
		
		assertEquals(OBJECT_ID, cargo.getId());
		assertEquals(TYPE, cargo.getVehicleType());
	}
	
	@Test
	public void testUpdateCargo()
	{
		cargo.setDeadline(parseDate(DEADLINE));
		cargo.setVehicleType(TYPE);
		
		cargoDAO.updateCargo(cargo);
		
		Cargo updatedCargo = cargoDAO.getCargo(OBJECT_ID);
		
		assertEquals(OBJECT_ID, updatedCargo.getId());
/*		assertEquals(UPDATED + ADDRESS_FROM, updatedCargo.getAddressFrom());
		assertEquals(UPDATED + ADDRESS_TO, updatedCargo.getAddressTo());*/		
		assertEquals(UPDATED + TYPE, updatedCargo.getVehicleType());
	}
	
	@Test
	public void testDeleteCargo()
	{
		cargoDAO.deleteCargo(OBJECT_ID);
		
		Cargo deletedCargo = cargoDAO.getCargo(OBJECT_ID);
		
		assertNull(deletedCargo);
	}
	
}
