package com.zyx2.glambda.mmm;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModeTest {
	static List<Float> numbers1;
	static List<Float> numbers2;
	static List<Float> numbers3;
	static List<Float> numbers4;
	
    @BeforeClass
    public static void createInput() {
    	// Single mode
    	numbers1 = new ArrayList<Float>();
    	numbers1.add(0f);
    	numbers1.add(1f);
    	numbers1.add(2f);
    	numbers1.add(1f);
    	
    	// No mode
    	numbers2 = new ArrayList<Float>();
    	numbers2.add(0f);
    	numbers2.add(1f);
    	numbers2.add(2f);
    	numbers2.add(3f);
    	
    	// Bimodal
    	numbers3 = new ArrayList<Float>();
    	numbers3.add(0f);
    	numbers3.add(1f);
    	numbers3.add(2f);
    	numbers3.add(2f);
    	numbers3.add(3f);
    	numbers3.add(3f);
    	
    	// Multimodal
    	numbers4 = new ArrayList<Float>();
    	numbers4.add(0f);
    	numbers4.add(1f);
    	numbers4.add(2f);
    	numbers4.add(2f);
    	numbers4.add(3f);
    	numbers4.add(3f);
    	numbers4.add(4f);
    	numbers4.add(4f);
    }
    
    @Test
    public void testModeSingle() {
    	List<Float> actualMode = Mode.compute(numbers1);
    	List<Float> expectedMode = new ArrayList<Float>();
    	expectedMode.add(1.0f);
    	Assert.assertTrue(actualMode.equals(expectedMode));
    }
    
    @Test
    public void testModeNone() {
    	List<Float> actualMode = Mode.compute(numbers2);
    	List<Float> expectedMode = new ArrayList<Float>();
    	Assert.assertTrue(actualMode.equals(expectedMode));
    }
    
    @Test
    public void testModeBiModal() {
    	List<Float> actualMode = Mode.compute(numbers3);
    	List<Float> expectedMode = new ArrayList<Float>();
    	expectedMode.add(2f);
    	expectedMode.add(3f);
    	Assert.assertTrue(actualMode.equals(expectedMode));
    }
    
    @Test
    public void testModeMultiModal() {
    	List<Float> actualMode = Mode.compute(numbers4);
    	List<Float> expectedMode = new ArrayList<Float>();
    	expectedMode.add(2f);
    	expectedMode.add(3f);
    	expectedMode.add(4f);
    	Assert.assertTrue(actualMode.equals(expectedMode));
    }
}