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
public class ArrayBasedQueue implements IArrayBased {
    private int size;
    private int front;
    private int rear;
    private Object [] Q;
    public ArrayBasedQueue(int n){
    this.front=this.rear=this.size=0;  //initialize the queue
    if (n<1) throw new RuntimeException("Invalid Size of Queue");
    Q = new Object[n];
    }
@Override
/**
* Inserts an item at the queue front.
*/
public void enqueue(Object item){
if (item==null) throw new RuntimeException("Invalid Item");
if (size==Q.length) throw new RuntimeException("Queue is full");
else {
    Q[rear]=item;
    rear = (rear+1) % Q.length;  
    size++;
}
}
/**
* Removes the object at the queue rear and returns it.
*/
@Override
public Object dequeue(){
Object element;
if (size==0) throw new RuntimeException("Queue is empty .. nothing to Serve");
else {
element = Q[front];
front=(front+1) % Q.length;
size--;
}
return element;
}
/**
* Tests if this queue is empty.
*/
@Override
public boolean isEmpty(){
return (size==0);
}
/**
* Returns the number of elements in the queue
*/
@Override
public int size(){
    return this.size;
}
}
