package eg.edu.alexu.csd.datastructure.stack;
/**
 *
 * @author Khalid Eltawagny
 * 
 */

public class Stack implements IStack {
 Singly_Linked_list stack = new Singly_Linked_list();
/**
* Pushes an item onto the top of this stack.
*
* @param object
* to insert
*/
@Override
public void push(Object element){
stack.add(element);
}
/**
* Tests if this stack is empty
*
* @return true if stack empty
*/
@Override
public boolean isEmpty(){
//    return (size==0);
return (stack.size()==0);
}
/**
* Removes the element at the top of stack and returns that element.
*
* @return top of stack element, or through exception if empty
*/
@Override
public Object pop(){
//if (!isEmpty()){
//Object element =top.entry;
//top =top.next;
//size--;
//return element;}
//else return null;
if (!stack.isEmpty()){
    Object element =stack.get(stack.size()-1);
    stack.remove(stack.size()-1);
    return element;
}
else throw new RuntimeException("Stack Empty");
}
/**
* Get the element at the top of stack without removing it from stack.
*
* @return top of stack element, or through exception if empty
*/
@Override
public Object peek(){
//return top.entry;
if (!stack.isEmpty()){
    return stack.get(stack.size()-1);
}
else throw new RuntimeException("Stack Empty");
}
/**
* Returns the number of elements in the stack.
*
* @return number of elements in the stack
*/
@Override
public int size(){
//return size;
return stack.size();
}
}
