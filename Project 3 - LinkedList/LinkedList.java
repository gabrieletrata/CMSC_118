
/**
 * Class for creating a linked list of any type.
 * 
 * @author Gabriel Etrata 
 * @version v1.0
 * @since 2016-05-06
 */
public class LinkedList<T>
{
    private Node<T> head;
    private Node<T> tail;
    /**
     * Constructor for initializing an empty linked list.
     * 
     */
   public LinkedList(){
    head = null;
    tail = null;
   }
    
    /**
     * Stores x in the list by creating a node object based on it and insterting the node at the beginning of this list.
     * 
     * @param x object of any given type inserted at the beginning of the list
     */
    public void addFirst(T x){
       Node<T> firstObj = new Node<T>(x);
       if(head == null && tail == null){
        head = firstObj;
        tail = firstObj;
       } else {
        firstObj.setNext(head);
        head.setPrevious(firstObj);
        head = firstObj;
        }
    }
    
    /**
     * Stores x in the list by creating a node object based on it and insterting the node at the end of this list.
     * 
     * @ param y object of any given type insterted at the end of the list.
     */
    public void addLast(T y){
       Node<T> lastObj = new Node<T>(y);
       if(head == null && tail == null){
         head = lastObj; 
         tail = lastObj;
       } else {
         lastObj.setPrevious(tail);
         tail.setNext(lastObj);
         tail = lastObj;
        }
    }
    
    /**
     * Retreives, but does not remove, the first object of this list, or returns null if this list is empty.
     */
    public T peekFirst(){
       if (head == null){
         return null;
       } else {
         return head.getData();
        }
    }

    /**
     * Retreives, but does not remove, the last object of this last, or returns null if this list is empty.
     */
    public T peekLast(){
       if(tail == null){
         return null;
       }else { 
         return tail.getData();
        }
    }
   
    /**
     * Retreives and removes the first object of this list, or returns null if this list is empty.
     */
    public T pollFirst(){
       if(head == null && tail == null){
         return null;
        }
    
       T firstPoll = head.getData();
       if( head == tail){
        head = null;
        tail = null;
        return firstPoll;
        }
    
       if (head.getNext() != null){
        head = head.getNext();
        head.setPrevious(null);    
        }
       return firstPoll;
    }
    
    /**
     * Retreives and removes the last object of this list, or returns null if this list is empty.
     */
    public T pollLast(){
       if(head == null && tail == null){
        return null;
        }
       
       T lastPoll = tail.getData(); 
       if( head == tail){
        head = null;
        tail = null;
        return lastPoll;
        }
       
       if(tail.getPrevious() != null){
        tail = tail.getPrevious();
        tail.setNext(null);
        }
       return lastPoll;
    }
    
    /**
     * Returns a string representation of all the items stored in the list.
     * For example, a string representation of an empty list appears like this: head--><--tail,
     * while a string representation of a non-empty list appears like this: head-->(1)object<-->--(2)object...-->(nth)object<--tail.
     * 
     */
    public String toString(){
       if(head == null && tail == null){
        return "head---><---tail";
        }
    
       String out = "";
       Node<T> current = head;
       if(head == tail){
        return "head--->" + current.getData() + "<---tail";
        }
        while(current != null){
            if(current == head){
            out = out + current.getData();
            current = current.getNext();
           }
           if(current != null){
            out = out + "<--->" + current.getData();
            current = current.getNext();
           }
         }
       return "head--->" + out + "<---tail";
    }
    
    /**
     * Static method that tests each of the methods in the LinkedList class.
     */
    public static void listTester(){    
    LinkedList<Integer> testIntList = new LinkedList<Integer>();
    System.out.println("***Testing for Objects of Type Integer***");
    testIntList.addFirst(1);
    testIntList.addFirst(2);
    testIntList.addFirst(3);
    testIntList.addFirst(4);
    testIntList.addLast(5);
    
    System.out.println("Integer List: " + testIntList.toString()); //Expected Output: head--->4<--->3<--->2<--->1<--->5<---tail
    System.out.println("Peek First: " + testIntList.peekFirst());//Expected Output: 4
    System.out.println("Peek Last: " + testIntList.peekLast()); //Expected Output: 5
    System.out.println("Poll First: " + testIntList.pollFirst()); //Expected Output:4
    System.out.println("Poll Last: " + testIntList.pollLast()); //Expected Output: 5
    System.out.println("Final Integer List: " + testIntList.toString()); //Expected Output: <3, 2, 1>
    
    System.out.println("");
    
    LinkedList<Double> testDoubleList = new LinkedList<Double>();
    System.out.println("***Testing for Objects of Type Double***");
    testDoubleList.addFirst(1.1);
    testDoubleList.addFirst(2.2);
    testDoubleList.addFirst(3.3);
    testDoubleList.addFirst(4.4);
    testDoubleList.addLast(5.5);
    
    System.out.println("Double List: " + testDoubleList.toString()); //Expected Output: head--->4.4<--->3.3<--->2.2<--->1.1<--->5.5<---tail
    System.out.println("Peek First: " + testDoubleList.peekFirst());//Expected Output: 4.4
    System.out.println("Peek Last: " + testDoubleList.peekLast()); //Expected Output: 5.5
    System.out.println("Poll First: " + testDoubleList.pollFirst()); //Expected Output: 4.4
    System.out.println("Poll Last: " + testDoubleList.pollLast()); //Expected Output: 5.5
    System.out.println("Final Double List: " + testDoubleList.toString()); //Expected Output: <3.3, 2.2, 1.1>
    
    System.out.println("");
    
    LinkedList<String> testStringList = new LinkedList<String>();
    System.out.println("***Testing for Objects of Type String***");
    testStringList.addFirst("John");
    testStringList.addFirst("Paul");
    testStringList.addFirst("George");
    testStringList.addLast("Ringo");
    testStringList.addLast("Gabriel");
    
    System.out.println("String List: " +  testStringList.toString()); //Expected Output: head--->George<--->Paul<--->John<--->Ringo<--->Gabriel<---tail
    System.out.println("Peek First: " + testStringList.peekFirst());//Expected Output: George
    System.out.println("Peek Last: " + testStringList.peekLast()); //Expected Output: Gabriel
    System.out.println("Poll First: " + testStringList.pollFirst()); //Expected Output: George
    System.out.println("Poll Last: " + testStringList.pollLast()); //Expected Output: Gabriel
    System.out.println("Final String List: " + testStringList.toString()); //Expected Output: <Paul, John, Ringo>
    
    System.out.println("");
    
    LinkedList<Integer> testNullList = new LinkedList<Integer>();
    System.out.println("***Testing for an empty list***");
    System.out.println("Null List: " + testNullList.toString()); //Expected Output: head---><---tail
    System.out.println("Peek First: " + testNullList.peekFirst());//Expected Output: null
    System.out.println("Peek Last: " + testNullList.peekLast()); //Expected Output: null
    System.out.println("Poll First: " + testNullList.pollFirst()); //Expected Output: null
    System.out.println("Poll Last: " + testNullList.pollLast()); //Expected Output: null
    System.out.println("Final List: " + testNullList.toString()); //Expected Output: head---><---tail
    }
}
