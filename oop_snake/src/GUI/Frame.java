package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import oop_snake.*;




public class Frame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5061483671145050013L;
	
	private Board panel;
	private JPanel panelCont;
	private JPanel top;
	private JButton topb;
	private CardLayout cl;
	private Image icon;
	
	public JPanel getTop() {
		return top;
	}

	public void setTop(JPanel top) {
		this.top = top;
	}
	
	
	public JButton getTopb() {
		return topb;
	}

	public CardLayout getCl() {
		return cl;
	}

	public JPanel getPanelCont() {
		return panelCont;
	}



	public Frame(Board pan){
	
		this.panel=pan;
		panelCont=new JPanel();
		setTop(new JPanel());
		topb=new JButton("Ranglist");
		cl=new CardLayout();
		

		  
		icon = Toolkit.getDefaultToolkit().getImage("src/resources/snake.png");  
		this.setIconImage(icon); 
		
		getPanelCont().setLayout(getCl());
		panel.setLayout(new BorderLayout());
		getTopb().setBackground(Color.DARK_GRAY);
		getTopb().setBorder(BorderFactory.createBevelBorder(0, Color.cyan, Color.green));
		getTopb().setForeground(Color.green);
		getTopb().setPreferredSize(new Dimension(Board.getheight(),Board.getunit()));
		panel.add(getTopb(), BorderLayout.PAGE_END);
		getTop().setLayout(new BorderLayout());
		
		getPanelCont().add(panel, "1");
		getPanelCont().add(getTop(), "2");
		
		getCl().show(getPanelCont(), "1");
		
		
			
		
		
		this.add(getPanelCont());
		this.setTitle("SNAKE");
		this.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	
		
	}

	

	

	
	
	
}
