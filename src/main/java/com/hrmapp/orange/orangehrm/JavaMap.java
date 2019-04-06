package com.hrmapp.orange.orangehrm;

import java.util.HashMap;
import java.util.Map;

public class JavaMap {
	public static void main(String[] args) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("1", "nikhil");
		map.put("2", "roshan");
		
		for (String s : map.keySet())
			System.out.println(s);
		
		for (String s : map.values())
			System.out.println(s);
	}
}