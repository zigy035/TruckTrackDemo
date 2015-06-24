package com.trucktrack.core.test.cargo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.trucktrack.core.module.cargo.dao.ICargoDAO;
import com.trucktrack.core.module.cargo.model.Cargo;
import com.trucktrack.core.test.CommonTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-test.xml")
public class CargoDAOTest extends CommonTest
{
	private static final String DEADLINE = "2012-12-12";
	private static final String ADDRESS_FROM = "addressFrom";
	private static final String ADDRESS_TO = "addressTo";
	private static final Double DIM_LENGTH = 100.0;
	private static final Double DIM_WEIGHT= 50.0;
	private static final String TYPE = "CONTAINER";
	
	
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
		cargo.setAddressFrom(ADDRESS_FROM);
		cargo.setAddressTo(ADDRESS_TO);
		cargo.setCityFrom("Belgrade");
		cargo.setCityTo("Wien");
		cargo.setPostcodeFrom("11000");
		cargo.setPostcodeTo("41500");
		cargo.setDimLength(DIM_LENGTH);
		cargo.setDimWeight(DIM_WEIGHT);
		cargo.setType(TYPE);
		
		cargoDAO.addCargo(cargo);
	}
	
	
	@Test
	public void testGetCargo()
	{
		Cargo cargo = cargoDAO.getCargo(OBJECT_ID);
		
		assertEquals(OBJECT_ID, cargo.getId());
		assertEquals(ADDRESS_FROM, cargo.getAddressFrom());
		assertEquals(ADDRESS_TO, cargo.getAddressTo());
		assertEquals(TYPE, cargo.getType());
	}
	
	@Test
	public void testUpdateCargo()
	{
		cargo.setDeadline(parseDate(DEADLINE));
		cargo.setAddressFrom(UPDATED + ADDRESS_FROM);
		cargo.setAddressTo(UPDATED + ADDRESS_TO);
		cargo.setType(UPDATED + TYPE);
		
		cargoDAO.updateCargo(cargo);
		
		Cargo updatedCargo = cargoDAO.getCargo(OBJECT_ID);
		
		assertEquals(OBJECT_ID, updatedCargo.getId());
		assertEquals(UPDATED + ADDRESS_FROM, updatedCargo.getAddressFrom());
		assertEquals(UPDATED + ADDRESS_TO, updatedCargo.getAddressTo());
		assertEquals(UPDATED + TYPE, updatedCargo.getType());
	}
	
	@Test
	public void testDeleteCargo()
	{
		cargoDAO.deleteCargo(OBJECT_ID);
		
		Cargo deletedCargo = cargoDAO.getCargo(OBJECT_ID);
		
		assertNull(deletedCargo);
	}
	
}
