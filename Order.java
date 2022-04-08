package shoppinggui;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Observable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chenduo Ouyang 19091093
 */
public class Order  extends Observable{

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    private ArrayList<OrderItem> orderItems ;
    private int OrderId ;
    private Date orderDate ;
    private String customerName ;
    private String address ;
    private String email;
    
    
    /**
     * Constructor 
     * set the OrderId when it is initialize 
     * @param ikm
     */
    public Order( IKeyManager keyman ) {
        this.OrderId = keyman.getNextId() ;
        this.orderItems = new ArrayList<OrderItem>();
        this.orderDate = new Date() ;
        
    }

    /** 
     * save the order and orderline to the database
     */
    public void save() {
        DataAccess doa = new DataAccess() ;
        doa.insertOrder(this) ;
        
        for (OrderItem orderItem : orderItems) {
            doa.insertOrderItem(orderItem) ;
        }
    }

    /**
     * delete order by order id
     */
    public void delete() {
        DataAccess doa = new DataAccess() ;
        doa.deleteOrder(OrderId) ;
    }
    
    /**
     * 
     * @return if this order has any order items
     */
    public Boolean hasItem() {
        return this.orderItems.size() > 0 ;
    }
    
    /**
     *
     * @param Id
     */
    public void removeItemById( int Id ) {
        Iterator itr = getOrderItems().iterator();

        while (itr.hasNext()) {
            OrderItem item = (OrderItem) itr.next();
            if (item.getId() == Id) {
                itr.remove();
                System.out.println("Removed OrderItem Id: " + Id);
                break;
            }
        }
        setChanged();
        notifyObservers(Id);        
    }
    
    /**
     *
     * @param item
     */
    public void addItem( OrderItem item ) {
        System.out.println("Order AddItem");

        this.orderItems.add(item) ;
        setChanged();
        notifyObservers(item);
    }
    
    /**
     * @return the orderItems
     */
    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    /**
     * @param orderItems the orderItems to set
     */
    public void setOrderItems(ArrayList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    /**
     * @return the OrderId
     */
    public int getOrderId() {
        return OrderId;
    }
    
    /**
     * return the total value for this order
     * @return 
     */
    public double getTotalValue() {
        double total = 0;
        for( OrderItem item: this.getOrderItems()) {
            total = total +  (item.getQty() * item.getProduct().getPrice()) ;
        }
        return total ;
    }
    

    /**
     * @return the orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }
    
    /**
     * return the order in formate "dd-mm-yyyy"
     * @return 
     */
    public String getFormatedOrderDate() {
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat dateformat = new SimpleDateFormat(pattern) ;
        return dateformat.format(orderDate) ;
    }
}
