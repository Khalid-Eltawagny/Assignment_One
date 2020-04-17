/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author Khalid Eltawagny
 */
public class Queue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedBasedQueue test = new LinkedBasedQueue();
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
    }
    
}
