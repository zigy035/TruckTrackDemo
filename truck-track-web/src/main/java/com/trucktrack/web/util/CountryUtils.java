package com.trucktrack.web.util;

import java.util.Arrays;
import java.util.List;

public class CountryUtils
{
	public static List<String> getCountryCodes()
	{
		String [] countryCodes = {"AL", "AN", "AM", "AT", "AZ", "BA", "BE", "BG", "BY", "CH", "CY", "CZ", "DE", "DK", "EE", "ES", "FI", 
				"FR", "GB", "GE", "GR", "HR", "HU", "IE", "IS", "IT", "KZ", "LI", "LT", "LU", "LV", "MC", "MD", "ME", "MK", "MT", "NL", 
				"NO", "PL", "PT", "RO", "RS", "RU", "SE", "SI", "SK", "TR", "UA"};
		
		/*String [] ccArray = {"AT", "DE", "RS"}; */
		
		return Arrays.asList(countryCodes);
	}
}
