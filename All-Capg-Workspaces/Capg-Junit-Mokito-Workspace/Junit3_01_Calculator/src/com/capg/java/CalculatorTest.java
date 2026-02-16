package com.capg.java;
import junit.framework.TestCase;
public class CalculatorTest extends TestCase{
	public void testAddition() {
		assertEquals(7,new Calculator().addition(2,5));
		assertEquals(6,new Calculator().subtraction(12,6));
	}
}
