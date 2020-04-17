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
class Node {
  public Object value;
  public Node next;
  
  public Node(Object val) {
    this.value = val;
    next = null;
  }
}
public class LinkedBasedQueue implements ILinkedBased {
    private int size;
    private Node front = null;
    private Node rear = null;
    public LinkedBasedQueue(){
        size=0;
    }
    @Override
/**
* Inserts an item at the queue front.
*/
public void enqueue(Object item){
if (item==null) throw new RuntimeException("Invalid Item");
if(size==0){
    Node newnode = new Node(item);
    front = rear = newnode;
    size++;
}else{
    Node newnode = new Node(item);
    rear.next=newnode;
    rear=newnode;
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
else if (size==1){
element=front.value;
front=rear=null;
size--;
}
else {
      element = front.value;
      front=front.next;
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
