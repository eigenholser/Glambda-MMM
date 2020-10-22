package com.zyx2.glambda.mmm;

import java.util.Collections;
import java.util.List;

public class Median {
	public static Float computeMedian(List<Float> numbers) {
		int size = numbers.size();
		Float median;
		Collections.sort(numbers);
		if (size % 2 == 0) {
			median = (numbers.get(size / 2) + numbers.get(size / 2 - 1)) / 2;
		} else {
			median = numbers.get(size / 2);
		}
		return median;
	}
}
