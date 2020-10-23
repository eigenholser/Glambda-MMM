package com.zyx2.glambda.mmm;

import java.util.List;

public class Mean {
	public static Float compute(List<Float> numbers) {
		Float mean = null;
		Float total = 0f;
		for (Float number : numbers) {
			total += number;
		}
		mean = total / numbers.size();
		return mean;
	}
}
