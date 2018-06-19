package zychaowill.algorithm.research.utils;

import java.util.Collection;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintlnUtils {

	public static <T> void sprintln(Collection<T> col) {
		if (col == null || col.isEmpty())
			return;
		String result = col.stream().map(String::valueOf).collect(Collectors.joining(","));
		log.info("result={}", result);
	}
	
	public static <T> void println(T t) {
		if (t == null)
			return;
		log.info("result={}", t.toString());
	}
}
