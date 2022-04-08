package shoppinggui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Chenduo Ouyang 19091093
 */
public class OrderItem {

    private Product product;
    private Integer Qty;
    private String size;
    private String color;
    private double lineTotal;
    private Integer id;
    private Integer orderId ;

    /**
     * overload constructor for the new id field
     * @param product
     * @param size
     * @param Qty
     * @param id
     * @param color 
     */
    public OrderItem(Product product, int Qty, String size, String color, int id) {
        this.id = id;
        this.product = product;
        this.Qty = Qty;
        this.size = size;
        this.color = color;
        setLineTotal();
    }

    
    /**
     * to be used by the shopping cart item
     * @return 
     */
    public String orderedItem() {
        String item = getProduct().getName()  ;
        if (!getSize().isEmpty()) {
            item = item + ", Size: " + this.getSize();
        }

        if (!getColor().isEmpty()) {
            item = item + ", Color: " + this.getColor();
        }
        return item ;
    }
    
    @Override
    public String toString() {
        String orderDetails = getId() + ": " + getQty() + " x " + getProduct().getName();
        if (!getSize().isEmpty()) {
            orderDetails = orderDetails + ", Size: " + this.getSize();
        }

        if (!getColor().isEmpty()) {
            orderDetails = orderDetails + ", Color: " + this.getColor();
        }

        orderDetails = orderDetails + String.format(" @%1.2f = %2.2f", getProduct().getPrice(), getLineTotal());

        return orderDetails;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the Qty
     */
    public int getQty() {
        return Qty;
    }

    /**
     * @param Qty the Qty to set
     */
    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the lineTotal
     */
    public double getLineTotal() {
        return lineTotal;
    }

    /**
     */
    public void setLineTotal() {
        this.lineTotal = getQty() * getProduct().getPrice();
    }

    /**
     * @return the orderId
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

}
