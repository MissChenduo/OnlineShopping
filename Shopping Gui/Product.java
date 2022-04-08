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
public abstract class Product {

    private int Id;
    private String name;
    private double price;
    private Category category;

    /**
     *
     * @param category
     * @param Id
     * @param name
     * @param price
     */
    public Product(Category category, int Id, String name, double price) {
        this.category = category;
        this.Id = Id;
        this.name = name;
        this.price = price;
    }

    /**
     *
     * @return
     */
    public String orderDetails() {
        return this.getName();
    }

    /**
     *
     * @return string for menu display
     */
    public String toMenuItem() {

        return getName() + ", Price: " + getPrice();
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {

        return getCategory() + ";"
                + getId() + ";"
                + getName() + ";"
                + getPrice();
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }
}
