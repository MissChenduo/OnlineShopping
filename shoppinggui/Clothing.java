package shoppinggui;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ChenDuo Ouyang 19091093
 */
public class Clothing extends Product {
    private ArrayList<String> sizes;
    private ArrayList<String> colors;
    
    public Clothing(Category category, int Id, String name, double price, 
            ArrayList<String> sizes, ArrayList<String> colors) {
        super(category, Id, name, price);
        setSizes(sizes);
        setColors(colors);
    }
    
      /**
     * @return the sizes
     */
    public ArrayList<String> getSizes() {
        return sizes;
    }

    /**
     * @param sizes the sizes to set
     */
    public void setSizes(ArrayList<String> sizes) {
        this.sizes = sizes;
    }

    /**
     * @return the colors
     */
    public ArrayList<String> getColors() {
        return colors;
    }

    /**
     * @param colors the colors to set
     */
    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }


}
