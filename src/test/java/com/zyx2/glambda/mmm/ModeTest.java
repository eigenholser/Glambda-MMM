package com.zyx2.glambda.mmm;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModeTest {
	static List<Float> numbers1;
	static List<Float> numbers2;
	
    @BeforeClass
    public static void createInput() {
    	numbers1 = new ArrayList<Float>();
    	numbers1.add(0f);
    	numbers1.add(1f);
    	numbers1.add(2f);
    	numbers1.add(1f);
    	
    	numbers2 = new ArrayList<Float>();
    	numbers2.add(0f);
    	numbers2.add(1f);
    	numbers2.add(2f);
    	numbers2.add(3f);
    }
    
    @Test
    public void testModeNotNone() {
    	Float mode = Mode.computeMode(numbers1);
    	Assert.assertTrue(mode.equals(1f));
    }
    
    @Test
    public void testModeNone() {
    	Float mode = Mode.computeMode(numbers2);
    	Assert.assertTrue(mode.equals(0f));
    }
}