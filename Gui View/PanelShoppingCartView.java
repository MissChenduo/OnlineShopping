/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiView;

import java.awt.Font;
import javax.swing.table.TableColumnModel;
import shoppinggui.IController;
import shoppinggui.Order;

/**
 *
 * @author Chenduo Ouyang 19091093
 */
public class PanelShoppingCartView extends javax.swing.JPanel {
    private ShoppingCartTableModel tableModel ;
    private Order order = null;
    private IController controller ;
    
    /**
     * Creates new form PanelShoppingCartView
     */
    public PanelShoppingCartView(  ) {
        //this.order = order ;
        this.tableModel = new ShoppingCartTableModel( order ) ;
        initComponents();
        //this.tableModel = new ShoppingCartTableModel( order ) ;
        Font font = new Font("Verdana",  Font.PLAIN, 14) ;
        tableOrder.setFont(font);
        tableOrder.getTableHeader().setFont(  new Font("Verdana",  Font.BOLD, 14) ) ;
        tableOrder.setRowHeight(25);
        lblTotalAmount.setText("0.00 ");
    }

    /**
     *
     * @param order
     */
    public void loadOrder(Order order) {
        this.order = order ;
        this.tableModel = new ShoppingCartTableModel( order ) ;
        tableOrder.setModel(tableModel);
        TableColumnModel colmodel  = tableOrder.getColumnModel() ;
        colmodel.getColumn(0).setPreferredWidth(400);
        tableOrder.setAutoResizeMode( 2); 
        
        
        
    }

    /**
     *
     * @param controller
     */
    public void setController(IController controller) {
        this.controller = controller ;
    }

    /**
     *
     */
    public void reloadData(  ) {
        this.tableModel.fireTableDataChanged();
        double total = this.order.getTotalValue() ;
        lblTotalAmount.setText( String.format("%.2f ", total) );
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        PanelBottom = new javax.swing.JPanel();
        btnCheckOut = new javax.swing.JButton();
        panelInner = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrder = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblTotalAmount = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();

        jLabel4.setText("jLabel4");

        setLayout(new java.awt.BorderLayout(5, 5));

        btnCheckOut.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCheckOut.setText("Check out");
        btnCheckOut.setPreferredSize(new java.awt.Dimension(150, 30));
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });
        PanelBottom.add(btnCheckOut);

        add(PanelBottom, java.awt.BorderLayout.SOUTH);

        panelInner.setBackground(new java.awt.Color(204, 204, 255));
        panelInner.setLayout(new java.awt.BorderLayout());

        tableOrder.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        tableOrder.setModel(tableModel);
        tableOrder.setGridColor(new java.awt.Color(102, 102, 102));
        tableOrder.setSelectionBackground(new java.awt.Color(255, 255, 153));
        tableOrder.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tableOrder);

        panelInner.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Your shopping cart has the following items.");
        jLabel1.setPreferredSize(new java.awt.Dimension(269, 30));
        jPanel1.add(jLabel1);

        panelInner.add(jPanel1, java.awt.BorderLayout.PAGE_START);
        panelInner.add(jPanel2, java.awt.BorderLayout.LINE_START);
        panelInner.add(jPanel3, java.awt.BorderLayout.LINE_END);

        jPanel4.setPreferredSize(new java.awt.Dimension(100, 50));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));
        jPanel4.add(jPanel6);

        jPanel5.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Total Amount:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel2.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel5.add(jLabel2, java.awt.BorderLayout.WEST);

        lblTotalAmount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotalAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalAmount.setText("20.00  ");
        lblTotalAmount.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        lblTotalAmount.setIconTextGap(5);
        lblTotalAmount.setPreferredSize(new java.awt.Dimension(100, 28));
        jPanel5.add(lblTotalAmount, java.awt.BorderLayout.CENTER);
        jPanel5.add(jPanel7, java.awt.BorderLayout.LINE_END);
        jPanel5.add(jPanel8, java.awt.BorderLayout.PAGE_START);
        jPanel5.add(jPanel9, java.awt.BorderLayout.PAGE_END);

        jPanel4.add(jPanel5);

        panelInner.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        add(panelInner, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
            // TODO add your handling code here:
           controller.actionPerformed(evt);
            
    }//GEN-LAST:event_btnCheckOutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBottom;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JPanel panelInner;
    private javax.swing.JTable tableOrder;
    // End of variables declaration//GEN-END:variables
}
