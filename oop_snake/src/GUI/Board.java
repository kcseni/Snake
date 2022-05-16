package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import oop_snake.Apple;
import oop_snake.Direction;
import oop_snake.Game;
import oop_snake.PlayerData;
import oop_snake.Snake;
import oop_snake.*;



public class Board extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7437563519377441017L;
	static final int width=640;
	static final int height=700;
	static final int unit=20;
	
	
	private String mode;
	private String name;

	private int highscore;
	
	Graphics g;
	Apple apples;
	Snake snake;
	
	Image apple;
	Image head;
	Image body;
	
	

	public static int getwidth() {
		return Board.width;
	}
		
	public static int getheight() {
		return Board.height;
	}
	
	public static int getunit() {
		return Board.unit;
	}
	
	public String getMode() {
		return this.mode;
	}
	
	public void setMode(String Mode){
		this.mode=Mode;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String nam) {
		this.name=nam;
	}
	
	public int getHighscore() {
		return highscore;
	}
	
	public void setHighscore(int high) {
		this.highscore=high;
	}
	


    
	public Board(String name, String mode, Snake s, Apple a){
		this.name=name;
		this.mode=mode;
		this.snake=s;
		this.apples=a;
		
		

		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.DARK_GRAY);
		loadImages();
		


	}
	
	public void loadImages() {

        ImageIcon iib = new ImageIcon("src/resources/body2.png");
        body = iib.getImage();

        ImageIcon iia = new ImageIcon("src/resources/apple2.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("src/resources/head2.png");
        head = iih.getImage();
        
        
    }
	
	public void draw(Graphics g) {
		if(Game.getRunning()) {
			g.setColor(Color.black);
			g.fill3DRect(unit, 4*unit, width-2*unit, height-5*unit, true);
			g.setColor(Color.DARK_GRAY);
			for(int i=0;i<height/unit;i++) {
				
				g.drawLine(i*unit, 0, i*unit, height);
				g.drawLine(0, i*unit, width, i*unit);
			}
			
			apples.paint(g, apple, this);		
			snake.paint(g, head, body, this);
			g.setColor(Color.GREEN);
			g.setFont(new Font("Chiller", Font.PLAIN, 40));
			FontMetrics metrics= getFontMetrics(g.getFont());
			String data="Name:"+this.name+"      Mode:"+this.mode+"      Score:"+snake.getapplesEaten();
			g.drawString( data,(width-metrics.stringWidth(data))/2, g.getFont().getSize());
		}else {
			gameOver(g);
		}
		
	}


	public void gameOver(Graphics g) {
		
		File file = new File("highest.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			}catch (IOException e){
				e.printStackTrace();
			}
		}
		if(file.length()==0) {
		try{
            PrintWriter writer = new PrintWriter(new FileWriter(file));
            writer.println(name+":"+snake.getapplesEaten());              
            writer.close();
            } catch(Exception ex){
            	ex.printStackTrace();
            }//creates .txt file
		}

      

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null)                 // read the score file line by line
            {
                try {
                	
                    int score = Integer.parseInt(line.split(":")[1]);   // parse each line as an int
                    String name2= line.split(":")[0];
                    if (score > snake.getapplesEaten() )                       // and keep track of the largest
                    { 
                    	
                    	highscore=score;
                    	name=name2;
                    	
                    }else {
                    	highscore=snake.getapplesEaten();
                 
                    	try{
                            PrintWriter writer = new PrintWriter(new FileWriter(file));
                            writer.println(name+":"+snake.getapplesEaten());              
                            writer.close();
                            } catch(Exception ex){
                            	ex.printStackTrace();
                            }//creates .txt file
                		}
                    	
                    }
                 catch (NumberFormatException e1) {
                    // ignore invalid scores
                    //System.err.println("ignoring invalid score: " + line);
                }
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException ex) {
            System.err.println("ERROR reading scores from file");
        }
        g.setColor(Color.green);
		g.setFont(new Font("Chiller", Font.ITALIC, 40));
		FontMetrics metrics= getFontMetrics(g.getFont());
		g.setFont(new Font("Chiller", Font.ITALIC, 70));
		FontMetrics metrics2= getFontMetrics(g.getFont());
		g.drawString("GAME OVER...", (width-metrics2.stringWidth("GAME OVER..."))/2, height/2);
		g.drawString("Your score: "+snake.getapplesEaten(), (width-metrics.stringWidth("GAME OVER..."))/4, height/4);
		g.drawString("High score: "+name+":"+highscore, (width-metrics.stringWidth("GAME OVER..."))/6, height/6);
	
	}
        
        

	
	
	


	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
		repaint();
		
		
	}
	
	
		
	
	
	

	


	
	
	
	
	
}
