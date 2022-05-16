package oop_snake;

import java.awt.event.KeyEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;

import GUI.Board;
import oop_snake.Game.MyKeyAdapter;

public class GameTest {

	Game game;
	@Before
	public void setUp() {
		game=new Game("valaki", "easy");
	}
	@Test
	public void IsStartSetRunning() {
		game.Start();
		boolean result=Game.getRunning();
		Assert.assertTrue(result);
	}
	@Test
	public void TestCheckCollisions() {
		game.getSnake().location.get(0).setLocation(25, 79);
		game.checkCollisions();
		boolean result=Game.getRunning();
		Assert.assertFalse(result);
	}
	
	
	
}
