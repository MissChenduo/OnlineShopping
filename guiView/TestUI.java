/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.event.AncestorListener;
import shoppinggui.Accessory;
import shoppinggui.Category;
import shoppinggui.DataAccess;
import shoppinggui.IController;
import shoppinggui.IKeyManager;
import shoppinggui.OrderController;
import shoppinggui.Product;
import shoppinggui.ProductController;
import shoppinggui.ProductFactory;
import shoppinggui.TestController;
import shoppinggui.TestKeyManager;

/**
 *
 * @author Chenduo Ouyang 19091093
 */
public class TestUI {

    public static void main(String[] args) {

 
        testCheckOut() ;

        
    }
    
    private static void testCheckOut() {
        
        
        ProductController pc = new ProductController();
        IKeyManager keymnan = new TestKeyManager();
        OrderController oc = new OrderController(keymnan, pc);
        IController controller = new TestController( oc );

        JDialog d = new JDialog();
        d.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        DataAccess doa = new DataAccess();
        Product p = doa.getProductById(1);
        oc.addOrderItem(p, 2, "XL", "Red");
        p = doa.getProductById(12);
        oc.addOrderItem(p, 1, "", "");
        d.setTitle("Checkout order");
        d.setResizable(false);
        PanelCheckOut chkout = new PanelCheckOut(controller);
        
        chkout.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.dispose();
            }
        
        });
        
        d.add(chkout);
        d.setLocation(200, 200);
        d.setSize(500, 500);
        d.setVisible(true);        
        
    }
    
    private static void TestPanelProducts() {
               DataAccess doa = new DataAccess();
        ArrayList<Product> ps = doa.getProductsByCategory(Category.Top) ;
        Product p = doa.getProductById(1);

        JDialog d = new JDialog();
        d.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        d.setTitle("Order view");
        d.setResizable(true);
        
        PanelProducts pan = new PanelProducts(  ) ;

        d.add(pan);
        d.setLocation(300, 300);
        d.setSize(680, 600);
        d.setVisible(true);
        pan.loadProducts(ps);
    }

    private static void TestPanelProduct() {
        // test Panelproduct view
        DataAccess doa = new DataAccess();
        Product p = doa.getProductById(1);

        JDialog d = new JDialog();
        d.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        d.setTitle("Order view");
        d.setResizable(true);
        
        PanelProduct pan = new PanelProduct( p ) ;

        d.add(pan);
        d.setLocation(200, 200);
        d.setSize(280, 300);
        d.setVisible(true);
        
    }

    private static void TestShoppingcarview() {
       // test shoppign cart view
        ProductController pc = new ProductController();
        IKeyManager keymnan = new TestKeyManager();
        OrderController oc = new OrderController(keymnan, pc);

        JDialog d = new JDialog();
        d.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        d.setTitle("Order view");
        d.setResizable(true);
        PanelShoppingCartView pan = new PanelShoppingCartView( );
        d.add(pan);
        d.setLocation(200, 200);
        d.setSize(800, 600);
        d.setVisible(true);        
        
        DataAccess doa = new DataAccess();
        Product p = doa.getProductById(1);
        oc.addOrderItem(p, 2, "XL", "Red");
        p = doa.getProductById(12);
        oc.addOrderItem(p, 1, "", "");
        pan.loadOrder(oc.getOrder()) ;
        pan.reloadData();
        //pan.loadOrder(oc.getOrder());
        
        
    }
    
    private static void TestOrderView() {
        Product product = ProductFactory.getProduct(Category.Top, 2,
                "Embossed Polo Shirt", 110.00,
                new String[]{"S", "M", "L"},
                new String[]{"Black", "White", "Grey"});

        //product = ProductFactory.getProduct(Category.Accessory, 13,
        //        "Duffle Bag", 80.00);
        OrderController controller = new OrderController( new TestKeyManager() );

        JDialog d = new JDialog();
        d.setTitle("Order Product");
        d.setResizable(false);
        PanelOrder pic = new PanelOrder(product, controller);
        d.add(pic);

        pic.getCloseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("closing dialog");
                d.dispose();
            }
        });

        d.setLocation(200, 200);
        d.setSize(800, 800);
        d.setVisible(true);

        System.exit(0);
    }

}
