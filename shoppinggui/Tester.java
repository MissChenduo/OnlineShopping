/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppinggui;

import java.util.ArrayList;

/**
 * for testing insert and delete products
 * @author Chenduo Ouyang 19091093
 */
public class Tester {

    public static void main(String[] args) {
        //insertBottom();
    }

    private static void getProducts() {

        DataAccess doa = new DataAccess();

        ArrayList<Product> products = doa.getProductsByCategory(Category.Top);

        for (Product product : products) {

            System.out.println(product);
            Clothing c = (Clothing) product;
            System.out.println(c.getSizes());

        }
    }

    private static void seedProduct() {

        ProductController pc = new ProductController(new dbKeyManager());
        pc.SeedProductData();

    }

    private static void deleteProduct() {
        DataAccess dao = new DataAccess();
        int res = dao.deleteProduct(1);
        System.out.println(String.format("delete result: %d ", res));
    }

    private static void insertShoes() {
        Product a = (Clothing) ProductFactory.getProduct(Category.Shoes, 17,
                "ADILETTE AQUA SLIDES", 130.00,
                new String[]{"5", "6", "7"},
                new String[]{"Platinum", "White", "Cloud"});
        DataAccess dao = new DataAccess();
        int res = dao.insertProduct(a);

        a = (Clothing) ProductFactory.getProduct(Category.Shoes, 18,
                "JEREMY SCOTT ADILETTE TEDDY SLIDES", 150.00,
                new String[]{"5", "6", "7", "8"},
                new String[]{"Orange", "Yellow", "Black"});

        res = dao.insertProduct(a);

        a = (Clothing) ProductFactory.getProduct(Category.Shoes, 20,
                "ZX 2K BOOST SHOES", 250.00,
                new String[]{"5", "6", "7", "8"},
                new String[]{"Core Black", " Silver Metallic ", "Solar Red"});

        res = dao.insertProduct(a);

        System.out.println(String.format("insert result: %d ", res));
    }

    private static void insertAccessory() {
        Product a = (Accessory) ProductFactory.getProduct(Category.Accessory, 3,
                "Duffle Bag", 50.00);
        DataAccess dao = new DataAccess();
        int res = dao.insertProduct(a);

        System.out.println(String.format("insert result: %d ", res));
    }

    private static void insertBottom() {
        Clothing c = (Clothing) ProductFactory.getProduct(Category.Bottom, 19,
                "ADIDAS 2000 LUXE OPEN HEM TRACK PANTS", 110.00,
                new String[]{"5", "6", "7", "8"},
                new String[]{"Bliss Orchid", "White"});
        DataAccess dao = new DataAccess();
        int res = dao.insertProduct(c);

        c = (Clothing) ProductFactory.getProduct(Category.Bottom, 20,
                "ADICOLOR CLASSICS TRACK PANTS", 110.00,
                new String[]{"5", "6", "7", "8"},
                new String[]{"Victory Crimson", "White"});
        res = dao.insertProduct(c);

    }

    private static void insertTop() {
        Clothing c = (Clothing) ProductFactory.getProduct(Category.Top, 2,
                "Sportsear Hoodie", 160.00,
                new String[]{"S", "M", "L"},
                new String[]{"Black", "White", "Green"});

        DataAccess dao = new DataAccess();
        int res = dao.insertProduct(c);

        System.out.println(String.format("insert result: %d ", res));

    }

}
