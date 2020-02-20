/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Khalid Eltawagny
 */
public class ClacTest {
    
    public ClacTest() {
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
     * Test of add method, of class Clac.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int x = 8;
        int y = 2;
        Clac instance = new Clac();
        int expResult = 10 ;
        int result = instance.add(x, y);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of divide method, of class Clac.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        int x = 7 ;
        int y = 2 ;
        Clac instance = new Clac();
        float expResult = 3.5F;
        float result = instance.divide(x, y);
        assertEquals(expResult, result, 0.0);
        
    }
    
}
