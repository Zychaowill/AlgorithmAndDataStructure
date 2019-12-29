package com.buildupchao.datastructure.basic.heap;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmallHeadHeapTest {
	
	@Test
	public void testSystemMethod() throws Exception {
		int[] elements = {1, 2, 3, 4, 5, 6, 7};
		int newLength = (elements.length * 3 >>> 1) + 1;
		elements = Arrays.copyOf(elements, newLength);
		String result = Arrays.stream(elements).mapToObj(Integer::new).map(String::valueOf).collect(Collectors.joining(","));
		log.info("-------------------------------------");
		log.info("result={}, size={}", result, newLength);
		log.info("-------------------------------------");
	}
}
