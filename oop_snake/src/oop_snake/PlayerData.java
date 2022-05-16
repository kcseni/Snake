package oop_snake;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class PlayerData extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6235323588853391146L;
	private List<Player> players = new ArrayList<Player>();

	
	 public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return getPlayers().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}
	
	@Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Name";
            case 1:
            	return "Mode";
            default:
                return "Score";
        }
    }
	
	@Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
            	return String.class;
            case 1:
            	return String.class;
            default:
            	return Integer.class;
           
                

        }
    }
	
	 @Override
	    public boolean isCellEditable(int rowIndex, int columnIndex) {
	        
	            return true;
	        
	    }

	    @Override
	    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	        Player player = getPlayers().get(rowIndex);
	        if(columnIndex == 0){
	            player.setName((String) aValue);
	        }else if(columnIndex==1) {
	        	player.setMode((String) aValue);
	        }
	        else if(columnIndex == 2){
	            player.setScore((Integer) aValue);
	        }
	    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Player player=getPlayers().get(rowIndex);
		switch(columnIndex) {
		case 0:
			return player.getName();
		case 1:
			return player.getMode();
		case 2:
			return player.getScore();
		}
		return null;
	}
	
	public void addPlayer(String Name, String Mode, int Score) {
        getPlayers().add(new Player(Name,Mode, Score));
        fireTableRowsInserted(0, getPlayers().size() - 1);
    }

}
