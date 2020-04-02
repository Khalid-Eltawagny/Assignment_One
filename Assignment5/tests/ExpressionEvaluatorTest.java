/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.datastructure.stack;

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
public class ExpressionEvaluatorTest {
  

    /**
     * Test of infixToPostfix method, of class ExpressionEvaluator.
     */
    @Test
    public void test_1() {
        String s1 = "(a / (b - c + d)) * (e - a) * c";
        String result1 = "a b c - d + / e a - * c *";
        ExpressionEvaluator test = new ExpressionEvaluator();
        // test 1
        assertEquals(result1,test.infixToPostfix(s1));
    }
    @Test
    public void test_2() {
        String s2 = "a / b - c + d * e - a * c";
        String result2 = "a b / c - d e * + a c * -";
        ExpressionEvaluator test = new ExpressionEvaluator();
        // test 2 
        assertEquals(result2,test.infixToPostfix(s2));
    }
    
    @Test (expected = RuntimeException.class)
    public void Invalid_input1() {
        String s3 = "a ** b + c";
        ExpressionEvaluator test = new ExpressionEvaluator();
        test.infixToPostfix(s3);
    }
    @Test (expected = RuntimeException.class)
    public void Invalid_input2() {
        String s3 = "1 + 2 (  9  + 8 *";
        ExpressionEvaluator test = new ExpressionEvaluator();
        test.infixToPostfix(s3);
    }
    
    @Test
    /**
     * Test of evaluate method, of class ExpressionEvaluator.
     */
    
    public void testEvaluate() {
        int val = 6;
        String s = "5 / 2 + 7/2";
        ExpressionEvaluator test = new ExpressionEvaluator();
        String s2 = test.infixToPostfix(s);
        assertEquals(6,test.evaluate(s2));
    }
    
}
