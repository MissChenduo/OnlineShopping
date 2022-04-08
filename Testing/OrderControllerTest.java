/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppinggui;

import guiView.PanelOrder;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Chenduo Ouyang 19091093
 */
public class OrderControllerTest {

    public OrderControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addOrderItem method, of class OrderController.
     */
    @Test
    public void testAddOrderItem() {
        System.out.println("addOrderItem");
        Product product = null;
        product = ProductFactory.getProduct(Category.Top, 1, "Test Product", 12.99,
                new String[]{"S", "M", "L"},
                new String[]{"Black", "White", "Grey"});
        int Qty = 1;
        String size = "X";
        String color = "Red";
        ProductController pc = new ProductController();
        OrderController oc = new OrderController(new TestKeyManager(), pc);
        int itemId = oc.addOrderItem(product, Qty, size, color);
        System.out.println("New ItemId: " + itemId);

        oc.printOrderItems();
        assertTrue(oc.getOrder().hasItem());
        oc.removeOrderItemById(itemId);
        assertTrue(!oc.getOrder().hasItem());
    }

       
    /**
     * Test of saveOrder method, of class OrderController.
     */
    @Test
    public void testSaveOrder() {
        System.out.println("saveOrder");
        Product product = null;
        product = ProductFactory.getProduct(Category.Top, 1, "Test Product", 12.99,
                new String[]{"S", "M", "L"},
                new String[]{"Black", "White", "Grey"});
        int Qty = 1;
        String size = "X";
        String color = "Red";
        ProductController pc = new ProductController();
        OrderController oc = new OrderController(new TestKeyManager(), pc);
        Order order = oc.getOrder();
        order.setAddress("123 Queens Road, Auckland");
        order.setEmail("yummi@gmail.com");
        order.setCustomerName("Chenduo");
        
        int itemId = oc.addOrderItem(product, Qty, size, color);
        System.out.println("New ItemId: " + itemId);
        oc.printOrderItems();
        oc.saveOrder();
        oc.deleteOrder();
    }


}
