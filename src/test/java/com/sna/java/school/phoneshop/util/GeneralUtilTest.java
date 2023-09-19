package com.sna.java.school.phoneshop.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GeneralUtilTest {

	@Test
	public  void testToIntegerList() {
		
		List<String> name = List.of("Dara" , "Cheata", "Thida");
		
		List<Integer> list =  GeneralUtil.toIntegersList(name);
		
		assertEquals(3, list.size());
		
	}

}
