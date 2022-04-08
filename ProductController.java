package shoppinggui;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Product Controller responsible for loading and saving products to a file
 *
 * @author Chenduo Ouyang 19091093
 */
public class ProductController {

    private ArrayList<Product> products;
    private IKeyManager keyman = null;

    /**
     * Constructor
     *
     * @param ikm
     */
    public ProductController(IKeyManager keyman) {
        this.keyman = keyman;
        initialise();
    }

    /**
     *
     */
    public ProductController() {
        initialise();
    }
    
    /**
     * obsoleted, use doa to get products now
     * return a list of products that match with the passed in category
     *
     * @param cat
     * @return
     */
    public ArrayList<Product> getProductsByCategory(Category cat) {
        ArrayList<Product> results = new ArrayList();

        return results;
    }

    /**
     * initialize the Controller. Loading the products from the file
     */
    private void initialise() {

        SeedProductData();
    }

    /**
     * if the no records in the product table we will create product list here
     */
    protected void SeedProductData() {
        DataAccess doa = new DataAccess();
        doa.createProductTable();
        int recordcount = doa.recordCount("PRODUCT");
        if (recordcount > 0) {
            return;
        }

        this.products = new ArrayList<>();
        // create tops
        Clothing c = (Clothing) ProductFactory.getProduct(Category.Top, 1,
                "Sportsear Hoodie", 160.00,
                new String[]{"S", "M", "L"},
                new String[]{"Black", "White", "Green"});

        products.add(c);

        c = (Clothing) ProductFactory.getProduct(Category.Top, 2,
                "Embossed Polo Shirt", 110.00,
                new String[]{"S", "M", "L"},
                new String[]{"Black", "White", "Grey"});

        products.add(c);

        c = (Clothing) ProductFactory.getProduct(Category.Top, 3,
                "Sleeveless Polo Shirt", 110.00,
                new String[]{"S", "M", "L"},
                new String[]{"Black", "White", "Yellow"});

        products.add(c);

        c = (Clothing) ProductFactory.getProduct(Category.Top, 4,
                "Club Tennis Polo Shirt", 160.00,
                new String[]{"S", "M", "L"},
                new String[]{"Black", "White", "Blue"});

        products.add(c);

        c = (Clothing) ProductFactory.getProduct(Category.Bottom, 5,
                "Techfit Long Tights", 120.00,
                new String[]{"S", "M", "L"},
                new String[]{"Black", "White", "Red"});

        products.add(c);

        c = (Clothing) ProductFactory.getProduct(Category.Bottom, 6,
                "Training Tights", 130.00,
                new String[]{"S", "M", "L"},
                new String[]{"Dark Grey", "White"});

        products.add(c);

        c = (Clothing) ProductFactory.getProduct(Category.Bottom, 7,
                "Ultimate Classic Skirt", 70.00,
                new String[]{"S", "M", "L"},
                new String[]{"Dark Grey", "White"});

        products.add(c);

        c = (Clothing) ProductFactory.getProduct(Category.Shoes, 8,
                "Classic Trainner", 220.00,
                new String[]{"5", "6", "7", "8", "9"},
                new String[]{"Black", "White"});

        products.add(c);

        c = (Clothing) ProductFactory.getProduct(Category.Shoes, 9,
                "Classic Running", 300.00,
                new String[]{"5", "6", "7", "8", "9"},
                new String[]{"Black", "White"});

        products.add(c);

        c = (Clothing) ProductFactory.getProduct(Category.Shoes, 10,
                "Ultraboost Running", 420.00,
                new String[]{"5", "6", "7", "8", "9"},
                new String[]{"Black", "White", "Orange"});

        products.add(c);

        Accessory a = (Accessory) ProductFactory.getProduct(Category.Accessory, 11,
                "Originals Pouch", 20.00);
        products.add(a);

        a = (Accessory) ProductFactory.getProduct(Category.Accessory, 12,
                "Trainer Bag", 150.00);

        products.add(a);

        a = (Accessory) ProductFactory.getProduct(Category.Accessory, 13,
                "Duffle Bag", 80.00);

        products.add(a);

        c = (Clothing) ProductFactory.getProduct(Category.Top, 14,
                "RUNNING CROP TOP", 150.00,
                new String[]{"S", "M", "L"},
                new String[]{"Black", "White"});

        products.add(c);

        c = (Clothing) ProductFactory.getProduct(Category.Top, 15,
                "2000 LUXE CROPPED TEE", 50.00,
                new String[]{"S", "M", "L"},
                new String[]{"Bliss Orchid"});

        products.add(c);

        c = (Clothing) ProductFactory.getProduct(Category.Shoes, 16,
                "TERREX VOYAGER 21 TRAVEL SHOES", 120.00,
                new String[]{"6", "7", "8", "9"},
                new String[]{"Black", "White", "Orange"});

        products.add(c);

        c = (Clothing) ProductFactory.getProduct(Category.Shoes, 17,
                "ADILETTE AQUA SLIDES", 130.00,
                new String[]{"5", "6", "7"},
                new String[]{"Platinum", "White", "Cloud"});
        products.add(c);

        c = (Clothing) ProductFactory.getProduct(Category.Shoes, 18,
                "JEREMY SCOTT ADILETTE TEDDY SLIDES", 150.00,
                new String[]{"5", "6", "7", "8"},
                new String[]{"Orange", "Yellow", "Black"});

        products.add(c);

        c = (Clothing) ProductFactory.getProduct(Category.Bottom, 19,
                "ADIDAS 2000 LUXE OPEN HEM TRACK PANTS", 110.00,
                new String[]{"5", "6", "7", "8"},
                new String[]{"Bliss Orchid", "White"});

        products.add(c);

        c = (Clothing) ProductFactory.getProduct(Category.Bottom, 19,
                "ADIDAS 2000 LUXE OPEN HEM TRACK PANTS", 110.00,
                new String[]{"5", "6", "7", "8"},
                new String[]{"Bliss Orchid", "White"});
        products.add(c);
        c = (Clothing) ProductFactory.getProduct(Category.Bottom, 20,
                "ADICOLOR CLASSICS TRACK PANTS", 110.00,
                new String[]{"5", "6", "7", "8"},
                new String[]{"Victory Crimson", "White"});
        products.add(c);

        for (Product p : products) {

            doa.insertProduct(p);

        }

    }

}
