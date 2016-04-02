package fenetres;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MyTableModelMesParticipations extends DefaultTableModel {

	public boolean isCellEditable(int row, int col) {
		return false;
	}
    
}
