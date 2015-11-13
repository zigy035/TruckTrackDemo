package com.trucktrack.core.module.cargo.importer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Loto739Importer {

	public static void main(String[] args) {
		Document doc;
		try
		{
			doc = Jsoup.connect("http://www.loto7-39.rs/result.php").timeout(30*1000).get();

			Elements holders = doc.getElementsByClass("documentation-holder");
			Element holder2015 = holders.get(0);
			Elements rows = holder2015.getElementsByClass("row");
			Map<Integer, List<Integer>> fixtureMap = new HashMap<Integer, List<Integer>>();
			Integer count = 0;
			for (Element row : rows)
			{
				Elements divs = row.getElementsByTag("div");
				String numbers = divs.get(2).text().trim();
//				System.out.println(numbers);
				
//				numbers = numbers.replaceAll("\\s","|");
				String[] strArray = numbers.split("\\s+");
				List<Integer> numList = new ArrayList<Integer>();
				for (int i=0; i<strArray.length; i++) {
					numList.add(Integer.valueOf(strArray[i]));
				}
				
				fixtureMap.put(count++, numList);
			}
			
			List<Integer> finalIntersectList = new ArrayList<Integer>();
			for (int i=0; i<fixtureMap.size()-1; i++) {
				finalIntersectList.addAll( findCommon(fixtureMap.get(i), fixtureMap.get(i+1)) );
			}
			
			Collections.sort(finalIntersectList);
			for (int i = 0; i < finalIntersectList.size(); i++) {
			    int value = finalIntersectList.get(i);
			    System.out.println(value + " ");
			}
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private static List<Integer> findCommon(List<Integer> list1, List<Integer> list2) {
		List<Integer> intersectList = new ArrayList<Integer>();
		for (Integer item1 : list1) {
			for (Integer item2 : list2) {
				if (item1.intValue() == item2.intValue()) {
					intersectList.add(item1);
				}
			}
		}
		
		return intersectList;
	}
	
	
	
	
	
	
}
