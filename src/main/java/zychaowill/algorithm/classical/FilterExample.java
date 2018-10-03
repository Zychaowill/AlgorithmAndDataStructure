package zychaowill.algorithm.classical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

public class FilterExample {

	public static void main(String[] args) {
		List<Wrapper> a = Arrays.asList(new Wrapper("test", 12), new Wrapper("test3", 100), new Wrapper("test2", 9));
		LinkedHashMap<String, Integer> standard = new LinkedHashMap<>();
		List<String> datas = a.stream()
			.sorted((x, y) -> Integer.compare(x.getSequence(), y.getSequence())).map(Wrapper::getValue)
			.collect(Collectors.toCollection(ArrayList::new));
		for (int i = 0; i < datas.size(); i++) {
			standard.put(datas.get(i), i);
		}

		String[] b = { "test", "test2", "test3" };
//		String[] c = { "test", "test6" };

		TreeMap<Integer, String> newB = new TreeMap<>();
		for (int k = 0; k < b.length; k++) {
			String el = b[k];
			int index = standard.getOrDefault(el, -1);
			if (index != -1) {
				newB.put(index, el);
			}
		}
		
		String result = newB.values().stream().filter(Objects::nonNull).collect(Collectors.joining(","));
		System.out.printf("The result for b is %s.\n", result);
	}

	@Data
	@AllArgsConstructor
	static class Wrapper {

		String value;
		int sequence;
	}
}
