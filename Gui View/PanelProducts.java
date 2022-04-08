/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiView;

import java.util.ArrayList;
import shoppinggui.OrderController;
import shoppinggui.Product;

/**
 *
 * @author kcheng
 */
public class PanelProducts extends javax.swing.JPanel {

    String sourceFolder = "";
    final String imageFolder = ".\\resources\\productsimages\\";
    ArrayList<Product> products  = new ArrayList();
    private OrderController orderController  ;

    public void loadProducts( ArrayList<Product> products ) {
        this.removeAll();
        this.revalidate();
        this.repaint();
        this.products = products ;
        addImagesFromFolder();
    }

    /**
     * load the PanelProduct from a product
     * @param product 
     */
    private void addImage(Product product) {
        PanelProduct pan = new PanelProduct(product);
        pan.setOrderController(orderController);
        this.add(pan);
    }

    /**
     * Load the products into a list of panelProduct
     */
    private void addImagesFromFolder() {
        for (Product product : products) {
            addImage(product) ;
        }
        this.validate();
    }

    /**
     * Creates new form Products
     */
    public PanelProducts() {
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
    }// </editor-fold>//GEN-END:initComponents

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}