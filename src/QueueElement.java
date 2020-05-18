
public class QueueElement<E> {

    private E e; //The queue element. 
    private QueueElement<E> next; //the next element of the linked list

    /**
     * Creates a queue element.
     *
     * @param e The element.
     * @param n The next element.
     */
    public QueueElement(E e, QueueElement<E> n) {
        this.e = e;
        this.next = n;
    }

    /**
     * Method to set the element
     *
     * @param e The element.
     */
    public void setElement(E e) {
        this.e = e;
    }

    /**
     * Method to set the next linked list element
     *
     * @param e The next element.
     */
    public void setNext(QueueElement<E> e) {
        this.next = e;
    }

    /**
     * Method to get the element.
     *
     * @return The element.
     */
    public E getElement() {
        return this.e;
    }

    /**
     * Method to get the next linked list element
     *
     * @return The next element.
     */
    public QueueElement<E> getNext() {
        return this.next;
    }
}
