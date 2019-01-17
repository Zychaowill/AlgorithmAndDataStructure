package com.buildupchao.algorithm.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintlnUtils {

	public static <T> void sprintln(Collection<T> col) {
		if (col == null || col.isEmpty())
			return;
		String result = col.stream().map(String::valueOf).collect(Collectors.joining(","));
		log.info("result={}", result);
	}
	
	public static void println(Object t) {
		if (t == null)
			return;
		log.info("result={}", String.valueOf(t));
	}
	
	public static void aprintln(int[] t) {
		if (ArrayUtils.isNotEmpty(t)) {
			String result = Arrays.stream(t).boxed().map(String::valueOf).collect(Collectors.joining(","));
			log.info("result={}", result);
		}
	}
}
