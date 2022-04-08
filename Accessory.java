package shoppinggui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * class for Accessory
 * @author ChenDuo Ouyang 19091093
 */


public class Accessory extends Product {

    /**
     * Constructor for Accessory
     * @param category
     * @param Id
     * @param name
     * @param price 
     */
    public Accessory(Category category, int Id, String name, double price ) {
        super(category, Id, name, price);
    }

}
