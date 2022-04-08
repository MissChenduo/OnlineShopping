/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiView;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import shoppinggui.OrderController;
import shoppinggui.Product;

/**
 *
 * @author kcheng
 */
public class PanelProduct extends javax.swing.JPanel implements Runnable {
    
    /**
     *
     */
    public Image image;
    private Integer orgWidth;
    private Integer orgHeight;
    private Integer scaledWidth;
    private Integer scaleHeight;
    private String imagefile;
    MediaTracker tracker;// w  w w.d  e  m o 2s  .c o  m
    Thread motor;
    private OrderController orderController;
    
    private Product product;
    final String imageFolder = ".\\resources\\productsimages\\";
    
    /**
     *
     * @param product
     */
    public PanelProduct(Product product) {
        this();
        this.product = product;
        this.lblProduct.setText(this.product.getName());
        imagefile = String.format("%s%s.jpg", imageFolder, product.getId());
        motor = new Thread(this);
        motor.setPriority(Thread.MIN_PRIORITY);
        motor.start();
    }

    /**
     * Creates new form PanelPic
     */
    public PanelProduct() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProduct = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lblProduct.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProduct.setText("product");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 189, Short.MAX_VALUE)
                .addComponent(lblProduct))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(this.orderController == null) {
            System.out.println("Something wrong here... the order Controller is not setup yet.");
        }
        
        JDialog d = new JDialog( );
        PanelOrder porder = new PanelOrder(product, this.orderController);
        this.orderController.setOrderView(porder);
        d.add(porder);
        porder.getCloseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.dispose();
            }
        });
        d.setLocation(350, 250);
        d.setSize(600, 600);
        d.setModal(true);
        d.setVisible(true);
    }//GEN-LAST:event_formMouseClicked
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.image == null) {
            return;
        }
        
        orgWidth = this.image.getWidth(null);
        orgHeight = this.image.getHeight(null);
        Graphics2D g2d = (Graphics2D) g;
        calculateScaledImage();
        Integer left = (this.getWidth() - scaledWidth) / 2;
        g2d.drawImage(this.image, left, 5, scaledWidth, scaleHeight, null);
    }
    
    private void calculateScaledImage() {
        float scaleFactor;
        if (orgWidth < orgHeight) {
            // fit Height
            scaleFactor = (float) orgHeight / (this.getHeight() - 24);
            
        } else {
            scaleFactor = (float) orgWidth / (this.getWidth() - 24);
        }
        scaleHeight = Math.round(orgHeight / scaleFactor);
        scaledWidth = Math.round(orgWidth / scaleFactor);
    }
    
    @Override
    public void run() {
        this.image = new ImageIcon(this.imagefile).getImage();
        this.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblProduct;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the orderController
     */
    public OrderController getOrderController() {
        return orderController;
    }

    /**
     * @param orderController the orderController to set
     */
    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }
}