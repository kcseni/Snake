package oop_snake;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PlayerDataTest {
	private List<Player> players = new ArrayList<Player>();
	PlayerData data=new PlayerData();
	@Test
	public void AddPlayerTest() {
		data.addPlayer("nina", "easy", 6);
		int now=data.getRowCount();
		Assert.assertEquals(1, now);
	}
}
