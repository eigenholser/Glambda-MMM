package com.zyx2.glambda.mmm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Mode {
	public static List<Float> compute(List<Float> numbers) {
		List<Float> mode = new ArrayList<Float>();
		Map<Float, Integer> numberCount = new HashMap<Float, Integer>();

		int n = numbers.size(), i, j;

		for (i = 0; i < n; ++i) {
			int count = 0;
			for (j = 0; j < n; ++j) {
				if (numbers.get(j).equals(numbers.get(i))) {
					++count;
				}
			}
			numberCount.put(numbers.get(i), count);
		}
		
		Map<Float, Integer> sortedNumberCount = getSortedMapByValues(numberCount);
		Integer maxCount = null;
		Iterator<Float> iterator = sortedNumberCount.keySet().iterator();
		if (iterator.hasNext()) {
			maxCount = sortedNumberCount.get(iterator.next());
		}
		
		// No mode. Each number occurs only once.
		if (maxCount.equals(1)) {
			return mode;
		}
		
		for (Map.Entry<Float, Integer> entry : sortedNumberCount.entrySet()) {
			Float key = entry.getKey();
			Integer value = entry.getValue();
			if (value.equals(maxCount)) {
				mode.add(key);
			}
		}
		return mode;
	}

	private static <K extends Comparable<K>, V extends Comparable<V>> Map<K, V> getSortedMapByValues(final Map<K, V> map) {
		Map<K, V> mapSortedByValues = new LinkedHashMap<K, V>();

		// Get all the entries from the original map and put it in a List
		List<Map.Entry<K, V>> list = new ArrayList<Entry<K, V>>(map.entrySet());

		// Sort the entries based on the value by custom Comparator
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Entry<K, V> entry1, Entry<K, V> entry2) {
				return entry2.getValue().compareTo(entry1.getValue());
			}
		});

		// Put all sorted entries in LinkedHashMap
		for (Map.Entry<K, V> entry : list)
			mapSortedByValues.put(entry.getKey(), entry.getValue());

		return mapSortedByValues;
	}
}
