package oop_snake;

import org.junit.Test;

import org.junit.Assert;

public class PlayerTest {
	Player player;
	@Test
	public void PlayerConstuctorisGood() {
		player=new Player("szuzi", "easy", 4);
		String name=player.getName();
		String mode=player.getMode();
		int score=player.getScore();
		Assert.assertEquals("szuzi", name);
		Assert.assertEquals("easy", mode);
		Assert.assertEquals(4, score);
	}
}
