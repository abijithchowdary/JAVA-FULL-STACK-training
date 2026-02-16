package com.capg.java;
import junit.framework.TestCase;
public class CalculationTest extends TestCase{
	
	Calculator a;
	public void setUp() {
		a = new Calculator();
	}
	public void testAddition() {
		assertEquals(5,a.addition(2, 3));
	}
	public void tearDown() {
		a = null;
	}
}
