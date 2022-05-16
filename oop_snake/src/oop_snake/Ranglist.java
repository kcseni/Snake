package oop_snake;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

import GUI.Frame;

public class Ranglist {
	private PlayerData data;
	
	public PlayerData getData() {
		return this.data;
	}
	
	public Ranglist() {
		try {
			  
			  data = new PlayerData();       
	            //System.out.println(new File(".").getAbsoluteFile());
	            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("players.dat"));
	            data.setPlayers((List<Player>)ois.readObject());
	            ois.close();
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        }
	}
	
	public void add_data(String name, String mode, Snake s) {
		data.addPlayer(name, mode, s.getapplesEaten());
	}
	
	
	
	public void save_data(File file){
		try {
	        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
	        oos.writeObject(data.getPlayers());
	        oos.close();
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    }
	}
	
	public void table(Frame frame) {
		JTable table = new JTable(data);
	    JScrollPane scrollPane = new JScrollPane(table);
	    table.setFillsViewportHeight(true);
	    frame.pack();
	    table.setFont(new Font("Chiller", Font.PLAIN, 25));
	    table.setForeground(Color.green);
	    table.setBackground(Color.black);
	    frame.getTop().add(scrollPane);
	    table.getTableHeader().setFont(new Font("Chiller", Font.BOLD, 40));
	    table.getTableHeader().setForeground(Color.green);
	    table.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.gray));
	    table.getTableHeader().setBackground(Color.black);
	    
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	    table.setDefaultRenderer(String.class, centerRenderer);
	    table.setDefaultRenderer(Integer.class, centerRenderer);
	    for(int x=0;x<(table.getColumnCount());x++){
	         table.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
	        }
	    
	    TableRowSorter<PlayerData> sorter = new TableRowSorter<>(data);
	    table.setRowSorter(sorter);
	    List<RowSorter.SortKey> sortKeys = new ArrayList<>();
	     
	    int columnIndexForMode = 1;
	    sortKeys.add(new RowSorter.SortKey(columnIndexForMode, SortOrder.ASCENDING));
	    
	    int columnIndexForScore = 2;
	    sortKeys.add(new RowSorter.SortKey(columnIndexForScore, SortOrder.DESCENDING));
	     
	    sorter.setSortKeys(sortKeys);
	    sorter.sort();
	    
	}
}
