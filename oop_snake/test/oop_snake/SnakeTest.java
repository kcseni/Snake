package oop_snake;



import org.junit.Before;

import org.junit.Test;



import java.awt.event.KeyEvent;

import org.junit.Assert;

public class SnakeTest {
	Snake snake;
	@Before
	public void setUp() {
		snake=new Snake();
	}
	
	@Test
	public void testSnakedefaultCoordinates() {
		int xcoord=(int)snake.location.get(0).getX();
		int ycoord=(int)snake.location.get(0).getY();
		Assert.assertEquals(20, xcoord);
		Assert.assertEquals(80, ycoord);
		
	}
	
	@Test
	public void testSnakeCollidedApple() {
		Apple apple=new Apple();
		int x=apple.getx();
		int y=apple.gety();
		Snake snake=new Snake(x,y);
		snake.collidedwithApple(apple);
		int newx=apple.getx();
		int newy=apple.gety();
		int result=snake.getapplesEaten();
		int re=snake.location.size();
		Assert.assertEquals(1, result);
		Assert.assertEquals(3, re);
		
	}
	
	@Test
	public void TestTailgrowt() {
		
		snake.tailgrow();
		int x=snake.location.size();
		Assert.assertEquals(3, x);
	}
	
	
	@Test
	public void TestCollidedWithRightBorder() {
		snake.location.get(0).setLocation(621, 81);
		boolean result=snake.bordercollision();
		Assert.assertTrue(result);
		
		snake.location.get(0).setLocation(30, 100);
		boolean result2=snake.bordercollision();
		Assert.assertFalse(result2);
	}
	
	@Test
	public void TestSelfcollision() {
		snake.tailgrow();
		snake.tailgrow();
		snake.tailgrow();
		snake.location.get(0).setLocation(80, 84);
		snake.location.get(4).setLocation(80, 84);
		boolean result=snake.selfcollision();
		Assert.assertTrue(result);
		
		
		snake.location.get(0).setLocation(80, 84);
		snake.location.get(4).setLocation(20, 80);
		boolean result2=snake.selfcollision();
		Assert.assertFalse(result2);
	}
	
	@Test
	public void TestSnakeMoves() {
		//moves right
		Snake snake2=new Snake();
		snake2.move();
		int x=(int) snake2.location.get(0).getX();
		int y=(int) snake2.location.get(0).getY();
		int x1=(int) snake2.location.get(1).getX();
		int y1=(int) snake2.location.get(1).getY();
		Assert.assertEquals(40, x);
		Assert.assertEquals(80, y);
		Assert.assertEquals(20, x1);
		Assert.assertEquals(80, y1);
		
		//moves down
		snake2.setdirection(Direction.down);
		snake2.move();
		int x2=(int) snake2.location.get(0).getX();
		int y2=(int) snake2.location.get(0).getY();
		int x3=(int) snake2.location.get(1).getX();
		int y3=(int) snake2.location.get(1).getY();
		Assert.assertEquals(40, x2);
		Assert.assertEquals(100, y2);
		Assert.assertEquals(40, x3);
		Assert.assertEquals(80, y3);
		
		//moves left
		snake2.setdirection(Direction.left);
		snake2.move();
		int x4=(int) snake2.location.get(0).getX();
		int y4=(int) snake2.location.get(0).getY();
		int x5=(int) snake2.location.get(1).getX();
		int y5=(int) snake2.location.get(1).getY();
		Assert.assertEquals(20, x4);
		Assert.assertEquals(100, y4);
		Assert.assertEquals(40, x5);
		Assert.assertEquals(100, y5);
		
		//moves up
		snake2.setdirection(Direction.up);
		snake2.move();
		int x6=(int) snake2.location.get(0).getX();
		int y6=(int) snake2.location.get(0).getY();
		int x7=(int) snake2.location.get(1).getX();
		int y7=(int) snake2.location.get(1).getY();
		Assert.assertEquals(20, x6);
		Assert.assertEquals(80, y6);
		Assert.assertEquals(20, x7);
		Assert.assertEquals(100, y7);
		
	}
	
	@Test
	public void TestSetApplesEaten() {
		snake.setapplesEaten(5);
		int n=snake.getapplesEaten();
		Assert.assertEquals(5, n);
	}
	
	
	
}
