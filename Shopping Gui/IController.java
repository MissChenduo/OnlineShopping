/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppinggui;

import guiView.HomeFrame;
import guiView.PanelCheckOut;
import guiView.PanelOrder;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Chenduo Ouyang 19091093
 */
public interface IController extends ActionListener{

    /**
     *
     * @param homeview
     */
    void setHomeView( HomeFrame homeview );

    /**
     *
     * @param orderview
     */
    void setOrderView( PanelOrder orderview);

    /**
     *
     * @param checkoutview
     */
    void setCheckOutView (PanelCheckOut checkoutview);

    /**
     *
     * @return
     */
    OrderController getOrderController();

    /**
     *
     * @param cat
     * @return
     */
    ArrayList<Product> loadProductsByCategory( String cat);
}
