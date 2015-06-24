package com.trucktrack.web.util;

import java.util.Arrays;
import java.util.List;

public class CountryUtils
{
	public static List<String> getCountryCodes()
	{
		/*String [] ccArray = {"AL", "AN", "AM", "AT", "AZ", "BA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};*/
		
		String [] ccArray = {"AT", "DE", "RS"};
		
		return Arrays.asList(ccArray);
	}
}
