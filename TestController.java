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
import java.util.ArrayList;
import javax.swing.JButton;

/**
 * This is a test controller implements IController
 *
 * @author Chenduo Ouyang 19091093
 */
public class TestController implements IController {

    private PanelOrder orderView;
    private OrderController orderController;
    private PanelCheckOut checkoutView;

    /**
     * default constructor
     */
    public TestController() {

    }

    /**
     * passing orderController to testController
     *
     * @param oc
     */
    public TestController(OrderController oc) {
        this.orderController = oc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton btnSource = (JButton) source;
            btnSource.getName();
            System.out.println("you have press: " + btnSource.getText());

            if (btnSource.getText().equalsIgnoreCase("Submit Order")) {

                System.out.println("You have check out");
            }

        }
    }

    /**
     *
     * @param ov
     */
    @Override
    public void setOrderView(PanelOrder ov) {
        this.orderView = ov;
    }

    /**
     *
     * @param cat
     * @return
     */
    public ArrayList<Product> loadProductsByCategory(String cat) {
        Category category = Category.valueOf(cat);
        DataAccess doa = new DataAccess();
        return doa.getProductsByCategory(category);

    }

    /**
     *
     * @param homeview
     */
    @Override
    public void setHomeView(HomeFrame homeview) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public OrderController getOrderController() {
        return this.orderController;
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
