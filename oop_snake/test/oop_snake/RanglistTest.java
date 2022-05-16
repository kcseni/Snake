package oop_snake;
import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class RanglistTest {
	Ranglist ranglist;
	Snake s;
	
	@Test
	public void TestAddData() {
		
		ranglist=new Ranglist();
		s=new Snake();
		s.setapplesEaten(5);
		int prev=ranglist.getData().getRowCount();
		ranglist.add_data("kökörcsiny", "hard", s);
		File file=new File("players.dat");
		int now=ranglist.getData().getRowCount();
		int x=(now-prev);
		Assert.assertNotEquals(prev, now);
		Assert.assertEquals(1, x);
	}
}
