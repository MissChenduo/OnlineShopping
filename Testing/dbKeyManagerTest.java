/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppinggui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chenduo Ouyang 19091093
 */
public class dbKeyManagerTest {
    
    public dbKeyManagerTest() {
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
     * Test of getNextId method, of class dbKeyManager.
     */
    @Test
    public void testGetNextId() {
        System.out.println("getNextId");
        dbKeyManager instance = new dbKeyManager();
        int expResult = -1;
        int result = instance.getNextId();
        System.out.println("result:" + result);
        assertTrue( result > 1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of intialiseTable method, of class dbKeyManager.
     */
    @Test
    public void testIntialiseTable() throws Exception {
        System.out.println("intialiseTable");
        dbKeyManager.intialiseTable();
        
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
