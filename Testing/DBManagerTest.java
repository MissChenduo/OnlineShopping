/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppinggui;

import java.sql.Connection;
import java.sql.ResultSet;
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
public class DBManagerTest {

    Connection con;

    public DBManagerTest() {
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
     * Test of getConnection method, of class DBManager.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        DBManager instance = new DBManager();
        Connection result = instance.getConnection();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of closeConnections method, of class DBManager.
     */
    @Test
    public void testCloseConnections() {
        System.out.println("closeConnections");
        DBManager instance = new DBManager();
        instance.closeConnections();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isTableExist method, of class DBManager.
     */
    @Test
    public void testIsTableExist() throws Exception {
        System.out.println("isTableExist");
        String sTablename = "nosuchtable";
        DBManager instance = new DBManager();
        boolean expResult = false;
        boolean result = instance.isTableExist(sTablename);
        assertEquals(expResult, result);

        // this create a nextid table
        dbKeyManager dbm = new dbKeyManager();
        sTablename = "NextId";
        expResult = true;
        result = instance.isTableExist(sTablename);
        assertEquals(expResult, result);
    }

}
