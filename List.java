import java.lang.IndexOutOfBoundsException;

/**
 * List ADT from Chapter 7.1 with the additions of clear and clone
 * @param <E> Element type
 */
public interface List<E> {

  /**
   * Return number of elements in the list
   * @return Number of elements
   */
  int size();

  /**
   * Returns whether the list is empty
   * @return True if the list is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Returns the element at index i
   * @param i Index
   * @return Element at i
   * @exception IndexOutOfBoundsException If i is not valid, exception
   */
  E get(int i) throws IndexOutOfBoundsException;

  /**
   * Replaces the element at index i with e, and returns the replaced element
   * @param i Index
   * @param e New element
   * @return Element replaced by e
   * @exception IndexOutOfBoundsException If i is not valid, exception
   */
  E set(int i, E e) throws IndexOutOfBoundsException;

  /**
   * Inserts element e to be at index i, shifting all subsequent elements later
   * @param i Index
   * @param e New element
   * @exception IndexOutOfBoundsException If i is not valid, exception
   */
  void add(int i, E e) throws IndexOutOfBoundsException;

  /**
   * Removes and returns the element at index i, shifting subsequent elements
   * earlier
   * @param i Index
   * @return Element previously at i
   * @exception IndexOutOfBoundsException If i is not valid, exception
   */
  E remove(int i) throws IndexOutOfBoundsException;

  /**
   * Empty the list
   */
  public void clear();

  /**
   * Construct a clone (copy) of the object.
   * @return New list object with the same structure. This copy should be
   * shallow, i.e., the individual elements are not cloned.
   */
  public List<E> clone();
}
