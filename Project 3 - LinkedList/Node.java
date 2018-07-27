
/**
 * Class for creating and managing Node objects in a linked list.
 * 
 * @author (Gabriel Etrata) 
 * @version (v1.0)
 * @since 2015-05-06
 */
public class Node<T>
{
  private T data;
  public Node<T> next;
  public Node<T> prev;
  /**
  * Constructor for object of type IntegerNode.
  * 
  * @param data data of any given type stored in the node
  */
  public Node(T data){
   this.data = data;
   }
  
   /**
    * Returns the data being stored by this node.
    * 
    * @return data data stored by the node
    */
   public T getData(){
    return data;
   }
   
   /**
    * Returns the next node that has been linked to this node.
    * 
    * @return next the next node linked to the current node
    */
   public Node<T> getNext(){
    return next;
   }
   
   /**
    * Returns the previous node that has been linked to this node.
    * 
    * @return prev the previous node linked to the previous node
    */
   public Node<T> getPrevious(){
    return prev;
   }
   
   /**
    * Sets the next node, so that this node is now linked to in.
    */
   public void setNext(Node<T> in){
    next = in;
   }
   
   /**
    * Sets the previous node, so that this node is now linked to in.
    */
   public void setPrevious(Node<T> in){
    prev = in;
   }
}
