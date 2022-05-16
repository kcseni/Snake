package oop_snake;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import GUI.*;

import javax.swing.Timer;

import GUI.Board;
import GUI.Frame;



public class Game implements ActionListener {
	private String name;
	private String mode;
	static boolean running=false;
	private int delay;

	private Board panel;
	private Timer timer;
	private Apple apple;
	private Snake snake;
	private Frame frame;
	private Ranglist ranglist;
	
	

	public Snake getSnake() {
		return this.snake;
	}
	
	public static boolean getRunning() {
		return Game.running;
	}
	
	public static void setRunning(boolean run){
		Game.running=run;
	}
	
	public Game(String name, String mode) {
		snake=new Snake();
		apple=new Apple();
		this.name=name;
		this.mode=mode;
		panel=new Board(name, mode, snake, apple);
		frame=new Frame(panel);
		ranglist=new Ranglist();
		panel.setFocusable(true);
		panel.addKeyListener(new MyKeyAdapter());
		
	
		switch(mode) {
		case "easy":
			this.delay=120;
			break;
		case "medium":
			this.delay=80;
			break;
		case "hard":
			this.delay=40;
			break;
		}
		
		Start();
	}
	
	
	

	

	public void Start() {

		running=true;
		timer=new Timer(delay, this);
		timer.start();
		
	
	}
	
	public void checkCollisions() {

		if(snake.selfcollision()==true || snake.bordercollision()==true) {
			running=false;
			timer.stop();
			
			//frame.add_data(name, mode, snake);
			ranglist.add_data(name, mode, snake);
			File file=new File("players.dat");
			ranglist.save_data(file);
			
		    
			frame.getTopb().addActionListener(new ActionListener(){
						
						@Override
						public void actionPerformed(ActionEvent e) {
							frame.getCl().show(frame.getPanelCont(), "2");
							ranglist.table(frame);
				           }
				       
							
							
			});
			
			
		}
	}
	
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(snake.getdirection()!= Direction.right) {
					snake.setdirection(Direction.left);
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(snake.getdirection()!=Direction.left) {
					snake.setdirection(Direction.right); 
				}
				break;
			case KeyEvent.VK_UP:
				if(snake.getdirection()!= Direction.down) {
					snake.setdirection(Direction.up);
				}
				break;
			case KeyEvent.VK_DOWN:
				if(snake.getdirection()!= Direction.up) {
					snake.setdirection(Direction.down);
				}
				break;
			}
		}
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(running) {
			
			snake.move();
			snake.collidedwithApple(apple);
			checkCollisions();
			

		}
		
		
	}
	
	
}
