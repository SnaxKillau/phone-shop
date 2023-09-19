package com.sna.java.school.phoneshop.util;

import java.util.List;

public class GeneralUtil {


	
	public static List<Integer> toIntegersList(List<String> list) {
		
		
		return list.stream().map(t -> t.length()).toList();
	}

}
