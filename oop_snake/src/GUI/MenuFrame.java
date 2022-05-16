package GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import oop_snake.*
;


public class MenuFrame extends JFrame {
	private Object[] mode={"easy", "medium", "hard"};
	private JTextField tf;
	private JComboBox cb;
	private JButton b;
	Image icon;


	
	
    private void initComponents() {
    	tf=new JTextField(15);
    	tf.setForeground(Color.green);
    	tf.setFont(new Font("Chiller", Font.BOLD, 20));
    	tf.setBackground(Color.black);
    	tf.setBorder(BorderFactory.createBevelBorder(0, Color.CYAN, Color.GREEN));
    	
    	cb=new JComboBox(mode);
    	cb.setBackground(Color.green);
    	cb.setFont(new Font("Chiller", Font.BOLD, 20));
    	
    	
		
		b=new JButton("START");
		b.setFont(new Font("Chiller", Font.BOLD, 20));
		b.addActionListener(new AddButtonListener());
		b.setBackground(Color.green);
		
		icon = Toolkit.getDefaultToolkit().getImage("src/resources/menu.png");  
		this.setIconImage(icon);
	

    	JPanel menuPlayer=new JPanel();
    	JLabel l1=new JLabel("Name:");
    	l1.setForeground(Color.green);
    	l1.setFont(new Font("Chiller", Font.BOLD, 25));
    	JLabel l2=new JLabel("Mode:");
    	l2.setFont(new Font("Chiller", Font.BOLD, 25));
    	l2.setForeground(Color.green);
		menuPlayer.add(l1);
		menuPlayer.add(tf);
		menuPlayer.add(l2);
		menuPlayer.add(cb);
		menuPlayer.add(b);
		menuPlayer.setBackground(Color.black);
		this.add(menuPlayer);
		this.setVisible(true);
		
    }
    
    final class AddButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	Game game=new Game(tf.getText(), cb.getSelectedItem().toString());
           
        	
        }
    }
    
    public MenuFrame() {
    	super("Menu");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 

        // Felépítjük az ablakot
        
        setMinimumSize(new Dimension(500,82));
        initComponents();

       
    }
    



	
}
