package com.capg.java;
import com.capg.java.Calculator;
import junit.framework.TestCase;

public class CalculationsTest extends TestCase{
		
		Calculator obj;
		
		public void setUp() {
			obj = new Calculator();
		}
		
		public void testAll() {
			
			
			assertEquals(5,obj.addition(2, 3));
			
			assertEquals(6,obj.multiplication(2, 3));
			
			assertEquals(1,obj.subtraction(2, 1));
			
			assertEquals(2,obj.divison(10,5));
		}
		
		public void tearDown() {
			obj = null;
		}
	}
