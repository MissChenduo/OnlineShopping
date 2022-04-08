package shoppinggui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Chenduo Ouyang 19091093
 */
public class ProductFactory {

    /**
     *
     * @param category
     * @param Id
     * @param name
     * @param price
     * @return
     */
    public static Product getProduct(Category category, int Id,
            String name, double price) {

        return getProduct(category, Id, name, price, null, null);
    }

    /**
     * Create a product and depends on the category it return different subclass
     *
     * @param category
     * @param Id
     * @param name
     * @param price
     * @param asizes
     * @param acolors
     * @return
     */
    public static Product getProduct(Category category, int Id,
            String name, double price,
            String[] asizes, String[] acolors) {

        switch (category) {
            case Top:
            case Bottom:
            case Shoes:
                ArrayList sizes = new ArrayList(Arrays.asList(asizes));
                ArrayList colors = new ArrayList(Arrays.asList(acolors));
                return new Clothing(category, Id, name, price, sizes, colors);
            case Accessory:
                return new Accessory(category, Id, name, price);
            default:
                throw new AssertionError();
        }
    }

    /**
     * load a product from a line store in the product file
     *
     * @param rs
     * @return product
     */
    public static Product loadProduct(ResultSet rs) {
        if (rs == null) {
            return null;
        }

        try {
            String cat = rs.getString("CATEGORY");
            Integer id = rs.getInt("ID");
            Double price = rs.getDouble("PRICE");
            String name = rs.getString("NAME");

            if (cat.equalsIgnoreCase("accessory")) {
                return getProduct(Category.Accessory, id, name, price);
            } else {
                String str = rs.getString("SIZE");
                str = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
                String[] sizes = str.split(", ");
                str = rs.getString("COLOR");
                str = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
                String[] colors = str.split(", ");

                return getProduct(Category.valueOf(cat), id, name, price,
                        sizes, colors);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null ;
    }

    /**
     * load a product from a line store in the product file
     *
     * @param productline
     * @return product
     */
    public static Product loadProduct(String productline) {
        if (productline.length() == 0) {
            return null;
        }
        String[] productDetails = productline.split(";");
        if (productDetails[0].equalsIgnoreCase("Accessory")) {
            return getProduct(Category.valueOf(productDetails[0]),
                    Integer.parseInt(productDetails[1]),
                    productDetails[2],
                    Double.parseDouble(productDetails[3]));

        } else {

            String str = productDetails[4];
            str = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
            String[] sizes = str.split(", ");
            str = productDetails[5];
            str = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
            String[] colors = str.split(", ");
            return getProduct(Category.valueOf(productDetails[0]),
                    Integer.parseInt(productDetails[1]),
                    productDetails[2],
                    Double.parseDouble(productDetails[3]),
                    sizes, colors);

        }
    }

}
