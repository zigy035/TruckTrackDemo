package com.trucktrack.core.common.enumeration;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum VehicleType {
	
	DUMP_TRAILER (0, "Dump trailer"),
	CURTAINSIDER (1, "Curtainsider"),
	THERMO (2, "Thermo"),
	MOVING_FLOOR (3, "Moving floor (Fill material)"),
	REFRIGERATOR (4, "Refrigerator" ),
	COIL_WELL (5, "Coil well");
		
	private static final Map<Integer, VehicleType> lookup = new HashMap<Integer, VehicleType>();
	private static final Map<String, VehicleType> lookupName = new HashMap<String, VehicleType>();
	static
	{
		for (VehicleType s : EnumSet.allOf(VehicleType.class))
		{
			lookup.put(s.getCode(), s);
			lookupName.put(s.getName(), s);
		}
	}
	
	private int code;
	private String name;
	
	private VehicleType(int code, String name)
	{
		this.code = code;
		this.name = name;
	}
	
	public int getCode()
	{
		return code;
	}

	public String getName()
	{
		return name;
	}

}
