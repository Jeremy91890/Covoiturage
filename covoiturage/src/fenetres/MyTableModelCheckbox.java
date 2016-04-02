package fenetres;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MyTableModelCheckbox extends DefaultTableModel {
    @Override
    
    public boolean isCellEditable(int row, int col) {
		return col == 6;
	}
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
      Class clazz = String.class;
      switch (columnIndex) {
        case 0:
          clazz = Integer.class;
          break;
        case 6:
          clazz = Boolean.class;
          break;
      }
      return clazz;
    }
    
    @Override
    public void setValueAt(Object aValue, int row, int column) {
        if (aValue instanceof Boolean && column == 6) {
          System.out.println("hello"+aValue);
          Vector rowData = (Vector)getDataVector().get(row);
          rowData.set(6, (boolean)aValue);
          fireTableCellUpdated(row, column);
        }
    }
}