package com.zyx2.glambda.mmm;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MedianTest {
	static List<Float> numbers;
	
    @BeforeClass
    public static void createInput() {
    	numbers = new ArrayList<Float>();
    	numbers.add(0f);
    	numbers.add(1f);
    	numbers.add(2f);
    	numbers.add(1f);
    }
    
    @Test
    public void testMedian() {
    	Float median = Median.computeMedian(numbers);
    	Assert.assertTrue(median.equals(1f));
    }
}