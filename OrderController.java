package shoppinggui;

import guiView.PanelOrder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Chenduo Ouyang 19091093
 */
public class OrderController implements ActionListener {

    private Order order;
    private ProductController pController;
    private IKeyManager keyman;
    private PanelOrder orderView;

    /**
     *
     * @param keyman
     */
    public OrderController(IKeyManager keyman) {
        this(keyman, new ProductController());
    }

    /**
     * this is the older constructor for assignment 1 obsoleted
     *
     * @param keyman
     * @param pController
     */
    public OrderController(IKeyManager keyman, ProductController pController) {
        this.pController = pController;
        this.order = new Order(keyman);
        this.keyman = keyman;
        intialiseDb();
    }

    public Integer addOrderItem(Product product, int Qty, String size, String color) {
        Integer newItemId = this.keyman.getNextId();
        OrderItem item = new OrderItem(product, Qty, size, color, newItemId);
        item.setOrderId(this.order.getOrderId());
        order.addItem(item);
        return newItemId;
    }

    /**
     * create order table if they don't exists
     */
    private void intialiseDb() {
        DataAccess dao = new DataAccess();
        dao.createOrderTable();
        dao.createOrderLineTable();
    }

    /**
     * remover orderItem
     *
     * @param id
     */
    public void removeOrderItemById(int id) {

        this.order.removeItemById(id);
    }

    /**
     *
     * @return order
     */
    public Order getOrder() {
        return this.order;
    }

    /**
     * Save the order to database
     */
    public void saveOrder() {
        this.order.save();
    }

    /**
     * delete this order
     */
    public void deleteOrder() {
        this.order.delete();
    }

    /**
     * Submit the order and get the customer details
     */
    public void submitOrder(String name, String address, String email) {
        order.setAddress(address);
        order.setCustomerName(name);
        order.setEmail(email);
        order.save();
    }

    /**
     * print order items
     */
    public void printOrderItems() {
        for (OrderItem item : order.getOrderItems()) {
            System.out.println(item.toString());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source.equals(orderView.getbtnAdd())) {
            Product product = orderView.getProduct();
            Integer qty = orderView.getOrderedQty();
            String size = orderView.getOrderedSize();
            String color = orderView.getOrderedColor();
            String output = String.format("%d x  %s,  %s,  %s", qty, product.getName(), size, color);
            System.out.println(output);
            addOrderItem(product, qty, size, color);
        }
    }

    /**
     * @return the orderView
     */
    public PanelOrder getOrderView() {
        return orderView;
    }

    /**
     * @param orderView the orderView to set
     */
    public void setOrderView(PanelOrder orderView) {
        this.orderView = orderView;
    }

}
