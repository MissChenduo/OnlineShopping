/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiView;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import shoppinggui.Order;
import shoppinggui.OrderItem;

/**
 *
 * @author Chenduo Ouyang 19091093
 */
public class ShoppingCartTableModel extends AbstractTableModel {

    private final boolean DEBUG = true;
    private String[] columnNames = {"Item",
        "Price",
        "Qty",
        "Line Total"};

    private Order order;

    
    public ShoppingCartTableModel(Order order) {
        this.order = order;
    }

    @Override
    public int getRowCount() {
        if(order==null) {
            return 0 ;
        }
        return order.getOrderItems().size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(order == null) {
            return null ;
        }
        
        ArrayList<OrderItem> items = this.order.getOrderItems();
        OrderItem item = this.order.getOrderItems().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return item.orderedItem();
            case 1:
                return item.getProduct().getPrice();
            case 2:
                return item.getQty();
            case 3:
                return item.getLineTotal();
        }
        return null;
    }

    /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
     */
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
         * Don't need to implement this method unless your table's
         * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.

        return (col == 2);

    }

    /*
         * Don't need to implement this method unless your table's
         * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        if (DEBUG) {
            System.out.println("Setting value at " + row + "," + col
                    + " to " + value
                    + " (an instance of "
                    + value.getClass() + ")");
        }

        if (col == 2) {
            this.order.getOrderItems().get(row).setQty((Integer) value);
        }
        fireTableCellUpdated(row, col);

        if (DEBUG) {
            System.out.println("New value of data:");
            printDebugData();
        }
    }

    private void printDebugData() {
        int numRows = getRowCount();
        int numCols = getColumnCount();
        System.out.println("--------------------------");
    }
}
