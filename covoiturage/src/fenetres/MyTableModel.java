package fenetres;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {
    @Override
    
    public boolean isCellEditable(int row, int col) {
		return false;
	}
   
}