package oop_snake;

import org.junit.Test;


import org.junit.Assert;

public class AppleTest {
	Apple apple;
	
	@Test
	public void testAppleConstructor() {
		apple=new Apple(30, 81);
		int x=apple.getx();
		int y=apple.gety();
		Assert.assertEquals(30, x);
		Assert.assertEquals(81, y);
	}
	
	@Test
	public void appleCoordinatesAreOnBoard() {
		apple=new Apple();
		int x=apple.getx();
		int y=apple.gety();
		boolean xOnBoard=(x>19 && x<621);
		boolean yOnBoard=(y>79 && y<681);
		boolean xNotonBoard=(x<20 || x>620);
		boolean yNotonBoard=(y<80 || y>680);
		Assert.assertTrue(xOnBoard);
		Assert.assertTrue(yOnBoard);
		Assert.assertFalse(xNotonBoard);
		Assert.assertFalse(yNotonBoard);
	
	}
	
	@Test
	public void TestAppleSetter() {
		apple=new Apple();
		apple.setx(50);
		apple.sety(100);
		int x= apple.getx();
		int y=apple.gety();
		Assert.assertEquals(50, x);
		Assert.assertEquals(100, y);
				
	}
	

}

