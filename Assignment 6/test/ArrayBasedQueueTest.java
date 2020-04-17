/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

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
public class ArrayBasedQueueTest {
    ArrayBasedQueue test = new ArrayBasedQueue(5);
    /**
     * Test1
     */
    @Test
    public void testEnqueue() {
        test.enqueue(1);
        test.enqueue(6);
        assertEquals(1,test.dequeue());
        assertEquals(6,test.dequeue());
    }
      /**
   * Test2.
   */
  @Test(expected = RuntimeException.class)
  public void testDeQueue() {

    test.enqueue(3);
    test.enqueue(4);
    test.enqueue(3);
    assertEquals(3,test.size());
    assertFalse(test.isEmpty());
    test.dequeue();
    test.dequeue();
    test.dequeue();
    test.dequeue();
  }
    /**
     * Test of isEmpty method, of class ArrayBasedQueue.
     */
    @Test
    public void testIsEmpty() {
        test.enqueue(7);
        test.enqueue(9);
        test.enqueue(3);
        test.enqueue(6);
        test.enqueue(2);
        test.dequeue();
        test.dequeue();
        test.dequeue();
        test.dequeue();
        test.dequeue();
        assertTrue(test.isEmpty());
    }

    /**
     * Test of size method, of class ArrayBasedQueue.
     */
    @Test
    public void testSize() {
        test.enqueue(7);
        test.enqueue(9);
        test.enqueue(3);
        test.enqueue(6);
        test.enqueue(2);
        assertEquals(5,test.size());
    }
    
      /**
   * Test3.
   */
  @Test(expected = RuntimeException.class)
  public void test3() {
    test = new ArrayBasedQueue(1);
    test.dequeue();
  }
    /**
   * Test4.
   */
  @Test(expected = RuntimeException.class)
  public void test4() {
    test = new ArrayBasedQueue(3);
    test.enqueue(1);
    test.enqueue(1);
    test.enqueue(1);
    test.enqueue(3);
  }
    
}
