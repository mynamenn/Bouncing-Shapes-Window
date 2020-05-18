
/**
 *
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).
 *
 * @author you
 *
 */
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue<T> {

    private T t;
    private QueueElement<T> head;
    private QueueElement<T> tail;

    /**
     * Constructs an empty Queue.
     */
    public Queue() {
        head = null;
        tail = null;
    }

    /**
     * Checks if queue is empty.
     * @return Returns true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (head == null) && (tail == null);
    }

    /**
     * Returns the element at the head of the queue
     * @return Returns the element at head of queue.
     */
    public T peek() throws NoSuchElementException {
        if (!isEmpty()) {
            return head.getElement();
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Removes the front element of the queue.
     */
    public void dequeue() throws NoSuchElementException {
        if (!isEmpty()) {
            if (head.getNext()!=null){
                head = head.getNext();
            }else{
                head = tail = null;
            }
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Puts an element on the back of the queue.
     * @param element Element that is added to the queue.
     */
    public void enqueue(T element) {
        QueueElement<T> newOne= new QueueElement<T>(element, null);
        if (!isEmpty()) {
            tail.setNext(newOne);
            tail= newOne;
        }else {
            head = tail= newOne;
        }

    }

    /**
     * Prints the full contents of the queue in order from head to
     * tail.
     */
    public void print() {
        if (!isEmpty()) {
            QueueElement<T> current = head;
            while (current.getElement() != null) {
                System.out.println(current.getElement());
                current= current.getNext();
                if (current==null){
                    return;
                }
            }
        } else {
            System.out.println("Queue is empty");
        }

    }

}
