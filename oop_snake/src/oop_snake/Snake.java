package oop_snake;


import java.util.function.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import GUI.Board;

public class Snake {
	
	private int x;
	private int y;
	private int applesEaten;
	private Direction direction;
	
	
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
	
	public void setdirection(Direction d) {
		this.direction=d;
	}
	
	public Direction getdirection() {
		return this.direction;
	}
	
	public int getapplesEaten() {
		return this.applesEaten;
	}
	
	public void setapplesEaten(int n) {
		this.applesEaten=n;
	}
	
	
	public ArrayList<Point> location;
	
	public Snake() {
		location=new ArrayList<Point>();
		location.add(new Point(Board.getunit(),4*Board.getunit()));
		location.add(new Point(Board.getunit(),4*Board.getunit()-1));
		this.setx(Board.getunit());
		this.sety(4*Board.getunit());
		direction=Direction.right;
		applesEaten=0;
		
		
	}
	
	public Snake(int x, int y) {
		location=new ArrayList<Point>();
		location.add(new Point(x,y));
		tailgrow();
		this.setx(x);
		this.sety(y);
		applesEaten=0;
		direction=Direction.right;
	}
	

	
	public void collidedwithApple(Apple a) {
		if((location.get(0).getX()==(a.getx()) && location.get(0).getY()==a.gety())) {
			tailgrow();
			applesEaten++;
			a.NewApple();
			

			
		}
		
	}
	
	public void tailgrow() {
		location.add(new Point((location.get(location.size()-1))));
		
	}
	
	public boolean selfcollision() {
		for(int i=1; i<location.size(); i++) {
			if(location.get(0).equals(location.get(i))) {
				return true;
			}
		}
		return false;
		
	}
	
	public boolean bordercollision() {
		if((location.get(0).getX()>(Board.getwidth()-2*Board.getunit()) || location.get(0).getX()<Board.getunit() || location.get(0).getY()>(Board.getheight()-2*Board.getunit()) || location.get(0).getY()<(4*Board.getunit()))){
			return true;
		}else {
			return false;
		}
		
	}
	
	public void move() {
		for(int i=location.size()-1; i>0; i--) {
			location.get(i).setLocation(location.get(i-1));
		}
		
		switch(direction) {
		case up:
			location.get(0).setLocation(location.get(0).getX(), location.get(0).getY()-Board.getunit());
			break;
		case down:
			location.get(0).setLocation(location.get(0).getX(), location.get(0).getY()+Board.getunit());
			break;
		case left:
			location.get(0).setLocation(location.get(0).getX()-Board.getunit(), location.get(0).getY());
			break;
		case right:
			location.get(0).setLocation(location.get(0).getX()+Board.getunit(), location.get(0).getY());
			break;
		}
	}
	
	public void paint(Graphics g, Image head, Image body, Board board) {
		for(int i=0; i<location.size(); i++) {
			if(i==0) {
				g.drawImage(head,(int)location.get(i).getX(), (int)location.get(i).getY(), board);
			}else if(i!=0) {
			g.drawImage(body, (int)location.get(i).getX(), (int)location.get(i).getY(), board);
			}
		}
	
	}
	
	
	
	
	
}
