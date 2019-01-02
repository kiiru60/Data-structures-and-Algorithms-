//Name:
import java.lang.IndexOutOfBoundsException;

/**
 * Queue ADT from Chapter 6.2 with the addition of clear and clone implemented
 * with an LinkedList
 * @param <E> Element type
 */
public class Queue<E> {

  //----------------------------------------------------------------------------
  //-- Private data
  //----------------------------------------------------------------------------

  /**
   * LinkedList storage
   */
  private LinkedList<E> queue;

  //----------------------------------------------------------------------------
  //-- Public methods
  //----------------------------------------------------------------------------

  /**
   * Construct empty queue
   */
  public Queue() {
    queue = new LinkedList<E>();
  }

  /**
   * Return number of elements in the queue
   * @return Number of elements
   */
  int size() {
    return queue.size();
  }

  /**
   * Returns whether the queue is empty
   * @return True if the queue is empty, false otherwise
   */
  boolean isEmpty() {
    return queue.isEmpty();
  }

  /**
   * Returns the first element
   * @return Front element of queue
   */
  E first() {
    return queue.get(0);
  }

  /**
   * Inserts element e into queue
   * @param e New element
   */
  void enqueue(E e) {
    queue.add(queue.size(), e);
  }

  /**
   * Removes first element from queue
   * @return Element previously at front
   */
  E dequeue() {
    return queue.remove(0);
  }

  /**
   * Empty the queue
   */
  public void clear() {
    queue.clear();
  }

  /**
   * Construct a clone (copy) of the object.
   * @return New queue object with the same structure. This copy should be
   * shallow, i.e., the individual elements are not cloned.
   */
  public Queue<E> clone() {
    Queue<E> q = new Queue<>();
    q.queue = (LinkedList<E>)queue.clone();
    return q;
  }
}
