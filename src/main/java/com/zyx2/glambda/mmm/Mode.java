package com.zyx2.glambda.mmm;

import java.util.List;

public class Mode {
	public static Float computeMode(List<Float> numbers) {
		Float maxValue = 0f;
		int maxCount = 0, n = numbers.size(), i, j;
		
		for (i = 0; i < n; ++i) {
			int count = 0;
			for (j = 0; j < n; ++j) {
				if (numbers.get(j).equals(numbers.get(i))) {
					++count;
				}
			}
			if (count > maxCount) {
				maxCount = count;
				maxValue = numbers.get(i);
			}
		}
		return maxCount > 1 ? maxValue : 0f;
	}
}
