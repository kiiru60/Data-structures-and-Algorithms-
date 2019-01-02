//Name:
import java.lang.IndexOutOfBoundsException;

/**
 * List ADT implemented with a doubly linked list
 * @param <E> Element type
 */
public class LinkedList<E> implements List<E> {

  //----------------------------------------------------------------------------
  //-- Nested class
  //----------------------------------------------------------------------------
  /**
   * Nested node class for linked structure
   */
  private static class Node<E> {
    /**
     * Element
     */
    private E element;
    /**
     * Previous node
     */
    private Node<E> prev;
    /**
     * Next node
     */
    private Node<E> next;

    /**
     * Constructor
     * @param e Element
     * @param p Previous node
     * @param n Next node
     */
    public Node(E e, Node<E> p, Node<E> n) {
      element = e;
      prev = p;
      next = n;
    }

    /**
     * Get element at node
     * @return Element
     * @exception IllegalStateException Attempting to access element from bad
     * node
     */
    public E getElement() throws IllegalStateException {
      if(prev == null || next == null)
        throw new IllegalStateException("Invalid node");
      return element;
    }

    /**
     * Get previous node
     * @return Previous node
     */
    public Node<E> getPrev() {
      return prev;
    }

    /**
     * Get next node
     * @return Next node
     */
    public Node<E> getNext() {
      return next;
    }

    /**
     * Set element
     * @param e Element
     */
    public void setElement(E e) {
      element = e;
    }

    /**
     * Set previous node
     * @param p Previous node
     */
    public void setPrev(Node<E> p) {
      prev = p;
    }

    /**
     * Set next node
     * @param n Next node
     */
    public void setNext(Node<E> n) {
      next = n;
    }
  }

  //----------------------------------------------------------------------------
  //-- Private data
  //----------------------------------------------------------------------------

  /**
   * Header sentinel
   */
  private Node<E> header;
  /**
   * Trailer sentinel
   */
  private Node<E> trailer;
  /**
   * Number of list elements
   */
  private int size = 0;

  //----------------------------------------------------------------------------
  //-- Public non-interface methods
  //----------------------------------------------------------------------------

  /**
   * Constructor for empty list
   */
  public LinkedList() {
    header = new Node<>(null, null, null);
    trailer = new Node<>(null, header, null);
    header.setNext(trailer);
  }

  //----------------------------------------------------------------------------
  //-- Implementation of Interface methods
  //----------------------------------------------------------------------------
  /**
   * Return number of elements in the list
   * @return Number of elements
   */
  public int size() {
    return size;
  }

  /**
   * Returns whether the list is empty
   * @return True if the list is empty, false otherwise
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns the element at index i
   * @param i Index
   * @return Element at i
   * @exception IndexOutOfBoundsException If i is not valid, exception
   */
  public E get(int i) throws IndexOutOfBoundsException {
    return findNode(i, size).getElement();
  }

  /**
   * Replaces the element at index i with e, and returns the replaced element
   * @param i Index
   * @param e New element
   * @return Element replaced by e
   * @exception IndexOutOfBoundsException If i is not valid, exception
   */
  public E set(int i, E e) throws IndexOutOfBoundsException {
    Node<E> n = findNode(i, size);
    E p = n.getElement();
    n.setElement(e);
    return p;
  }

  /**
   * Inserts element e to be at index i, shifting all subsequent elements later
   * @param i Index
   * @param e New element
   * @exception IndexOutOfBoundsException If i is not valid, exception
   */
  public void add(int i, E e) throws IndexOutOfBoundsException {
    Node<E> n = findNode(i, size+1);
    Node<E> newn = new Node<>(e, n.getPrev(), n);
    n.getPrev().setNext(newn);
    n.setPrev(newn);
    ++size;
  }

  /**
   * Removes and returns the element at index i, shifting subsequent elements
   * earlier
   * @param i Index
   * @return Element previously at i
   * @exception IndexOutOfBoundsException If i is not valid, exception
   */
  public E remove(int i) throws IndexOutOfBoundsException {
    Node<E> n = findNode(i, size);
    n.getPrev().setNext(n.getNext());
    n.getNext().setPrev(n.getPrev());
    --size;
    return n.getElement();
  }

  /**
   * Empty the list
   */
  public void clear() {
    while(!isEmpty())
      remove(0);
  }

  /**
   * Construct a clone (copy) of the object.
   * @return New linked list object with the same structure. This copy should be
   * shallow, i.e., the individual elements are not cloned.
   */
  public List<E> clone() {
    LinkedList<E> l = new LinkedList<>();
    Node<E> n = header.getNext();
    for(int i = 0; i < size; ++i) {
      l.add(i, n.getElement());
      n = n.getNext();
    }
    return l;
  }

  //----------------------------------------------------------------------------
  //-- Private helper methods
  //----------------------------------------------------------------------------
  /**
   * Find a node for a given index
   * @param i Index
   * @param sz Upper limit of index
   * @return Node at i
   * @exception IndexOutOfBoundsException If i is not valid, exception
   */
  private Node<E> findNode(int i, int sz) throws IndexOutOfBoundsException {
    //check index
    if(i < 0 || i >= sz)
      throw new IndexOutOfBoundsException("Illegal index: " + i);

    Node<E> n;
    //Search from front
    if(i < size/2) {
      n = header;
      for(int p = -1; p < i; ++p)
        n = n.getNext();
    }
    //Search from back
    else {
      n = trailer;
      for(int p = size; p > i; --p)
        n = n.getPrev();
    }

    return n;
  }
}
