package oop_snake;
import GUI.Board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

import GUI.Board;

public class Apple {
	private int x;
	private int y;
	
	
	public void setx(int n) {
		this.x=n;
	}
	public void sety(int m) {
		this.y=m;
	}
	public int getx() {
		return this.x;
	}
	public int gety() {
		return this.y;
	}
	
	Random random=new Random();
	
	public Apple() {
		this.x= random.nextInt((Board.getwidth()-40)/Board.getunit())*Board.getunit()+Board.getunit();
		this.y= random.nextInt((Board.getheight()-100)/Board.getunit())*Board.getunit()+4*Board.getunit();
	}
	
	public Apple(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public void NewApple() {
		this.x= random.nextInt((Board.getwidth()-40)/Board.getunit())*Board.getunit()+Board.getunit();
		this.y= random.nextInt((Board.getheight()-100)/Board.getunit())*Board.getunit()+4*Board.getunit();
	}
	

	
	

	public void paint(Graphics g, Image apple, Board board) {
		
		g.drawImage(apple, this.x, this.y, board);
	}

	
}
