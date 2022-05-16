package oop_snake;

import java.io.Serializable;

public class Player implements Serializable{
	private String name;
	private String mode;
	private int score;
	
	public String getName() {
		return this.name;
	}
	
	public String getMode() {
		return this.mode;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setName(String Name) {
		this.name=Name;
	}
	
	public void setMode(String Mode) {
		this.mode=Mode;
	}
	
	public void setScore(int Score) {
		this.score=Score;
	}
	
	public Player(String Name, String Mode, int Score) {
		this.name=Name;
		this.mode=Mode;
		this.score=Score;
	}
}
