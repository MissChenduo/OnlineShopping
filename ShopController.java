/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppinggui;

import guiView.HomeFrame;
import guiView.PanelCheckOut;
import guiView.PanelOrder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Chenduo Ouyang 19091093
 */
public class ShopController implements IController {

    private PanelOrder orderview;
    private HomeFrame homeview;
    private OrderController orderController;
    private PanelCheckOut checkoutView;
    private JDialog checkoutDialog;

    /**
     * constructor that accept the order controller
     *
     * @param oc
     */
    public ShopController(OrderController oc) {
        this.orderController = oc;
    }

    /**
     *
     * @param orderview
     */
    @Override
    public void setOrderView(PanelOrder orderview) {
        this.orderview = orderview;
    }

    /**
     *
     * @param cat
     * @return
     */
    @Override
    public ArrayList<Product> loadProductsByCategory(String cat) {
        Category category = Category.valueOf(cat);
        DataAccess doa = new DataAccess();
        return doa.getProductsByCategory(category);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source.equals(homeview.getBtnAccessories())) {

            UpdateProductPanel(Category.Accessory.toString());
        }
        if (source.equals(homeview.getBtnTop())) {
            UpdateProductPanel(Category.Top.toString());
        }
        if (source.equals(homeview.getBtnBottom())) {
            UpdateProductPanel(Category.Bottom.toString());
        }
        if (source.equals(homeview.getBtnShoes())) {
            UpdateProductPanel(Category.Shoes.toString());
        }
        if (checkoutView != null) {
            if (source.equals(checkoutView.getBtnSubmitOrder())) {
                if (this.checkoutDialog != null) {
                    System.out.println("Order details:");
                    System.out.println("  name: " + checkoutView.getCustomerName());
                    System.out.println("  address: " + checkoutView.getAddress());
                    System.out.println("  email: " + checkoutView.getEmail());
                    orderController.submitOrder(checkoutView.getCustomerName(),
                            checkoutView.getAddress(),
                            checkoutView.getEmail());
                    checkoutDialog.dispose();
                }
                JOptionPane.showMessageDialog(homeview, "Thank you for shopping with us.");
                homeview.dispose();
            }
        }

        if (source instanceof JButton) {
            JButton btnSource = (JButton) source;
            btnSource.getName();
            if (btnSource.getText().equalsIgnoreCase("check out")) {
                if (this.orderController.getOrder().hasItem()) {
                    processOrder();
                } else {
                    JOptionPane.showMessageDialog(homeview, "You haven't ordered anything yet.");
                }
            }
        }

    }

    private void processOrder() {

        JDialog d = new JDialog(this.homeview, true);
        PanelCheckOut chkout = new PanelCheckOut(this);
        this.checkoutView = chkout;
        checkoutDialog = d;
        chkout.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkoutView = null;
                d.dispose();
            }
        });
        d.add(chkout);
        d.setSize(500, 500);
        d.setResizable(false);
        d.setLocationRelativeTo( homeview) ;
        d.setVisible(true);

    }

    /**
     * load the product panels
     *
     * @param cat
     */
    private void UpdateProductPanel(String cat) {
        homeview.getPanelShoppingCart().setVisible(false);
        homeview.getPanelWelcome().setVisible(false);
        homeview.getPanelProducts().setVisible(true);
        homeview.getPanelProducts().loadProducts(loadProductsByCategory(cat));
    }

    /**
     *
     * @param homeview
     */
    @Override
    public void setHomeView(HomeFrame homeview) {
        this.homeview = homeview;
    }

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

    /**
     *
     * @param checkoutview
     */
    @Override
    public void setCheckOutView(PanelCheckOut checkoutview) {
        this.checkoutView = checkoutview;
    }

}
