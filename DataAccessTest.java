/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppinggui;

import java.sql.ResultSet;
import java.util.ArrayList;
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
public class DataAccessTest {

    public DataAccessTest() {
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
     * Test of createProductTable method, of class DataAccess.
     */
    @Test
    public void testCreateProductTable() {
        System.out.println("CreateProductTable");
        DataAccess instance = new DataAccess();
        instance.createProductTable();

    }

    @Test
    public void testRecordCount() {
        System.out.println("insertProduct");

        DataAccess instance = new DataAccess();
        int result = instance.recordCount("PRODUCT");
        System.out.println("record count for product:  " + result);
        assertTrue(result >= 0);
    }

    /**
     * Test of insertProduct method, of class DataAccess.
     */
    @Test
    public void testInsertProduct() {
        System.out.println("insertProduct");

        IKeyManager keyman = new dbKeyManager();
        int productId = keyman.getNextId();

        Clothing product = (Clothing) ProductFactory.getProduct(Category.Top, productId,
                "Sportsear Hoodie", 160.00,
                new String[]{"S", "M", "L"},
                new String[]{"Black", "White", "Green"});

        DataAccess instance = new DataAccess();
        int expResult = 1;
        int result = instance.insertProduct(product);
        assertEquals(expResult, result);

        System.out.println("deleteProduct");

        result = instance.deleteProduct(productId);
        assertEquals(expResult, result);

    }

    /**
     * Test of deleteProduct method, of class DataAccess.
     */
    @Ignore
    public void testDeleteProduct() {
        System.out.println("deleteProduct");
        int Id = 0;
        DataAccess instance = new DataAccess();
        int expResult = 0;
        int result = instance.deleteProduct(Id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductById method, of class DataAccess.
     */
    @Test
    public void testGetProductById() {
        System.out.println("getProductById");
        Integer id = 1;
        DataAccess instance = new DataAccess();

        Product product = instance.getProductById(id);
        System.out.println("Product: " + product);
        assertTrue(product != null);
    }

    /**
     * Test of getProductsByCategory method, of class DataAccess.
     */
    @Test
    public void testGetProductsByCategory() {
        System.out.println("getProductsByCategory");
        Category cat = Category.Top;
        DataAccess instance = new DataAccess();
        ArrayList<Product> result = instance.getProductsByCategory(cat);
        assertTrue(result != null);
    }

}
