//Name:
import java.lang.IndexOutOfBoundsException;

/**
 * List ADT implemented with dynamic array
 * @param <E> Element type
 */
public class ArrayList<E> implements List<E> {

  //----------------------------------------------------------------------------
  //-- Private data
  //----------------------------------------------------------------------------

  /**
   * Initial capacity
   */
  private static final int INITIAL_CAPACITY = 2;
  /**
   * Growth constant
   */
  private static final int GROWTH_CONSTANT = 10;
  /**
   * Elements array
   */
  private E[] data;
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
  public ArrayList() {
    this(INITIAL_CAPACITY);
  }

  /**
   * Constructor for empty list with non-default capacity
   * @param c Capacity
   */
  public ArrayList(int c) {
    @SuppressWarnings("unchecked")
    E[] e = (E[])new Object[c];
    data = e;
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
    checkIndex(i, size);
    return data[i];
  }

  /**
   * Replaces the element at index i with e, and returns the replaced element
   * @param i Index
   * @param e New element
   * @return Element replaced by e
   * @exception IndexOutOfBoundsException If i is not valid, exception
   */
  public E set(int i, E e) throws IndexOutOfBoundsException {
    checkIndex(i, size);
    E temp = data[i];
    data[i] = e;
    return temp;
  }

  /**
   * Inserts element e to be at index i, shifting all subsequent elements later.
   * This method will use the doubling strategy for growth
   * @param i Index
   * @param e New element
   * @exception IndexOutOfBoundsException If i is not valid, exception
   */
  public void add(int i, E e) throws IndexOutOfBoundsException {
    add(i, e, 2*data.length);
  }

  /**
   * Inserts element e to be at index i, shifting all subsequent elements later.
   * This method will use an incremental strategy for growth
   * @param i Index
   * @param e New element
   * @exception IndexOutOfBoundsException If i is not valid, exception
   */
  public void addGrowConstant(int i, E e) throws IndexOutOfBoundsException {
    add(i, e, data.length + GROWTH_CONSTANT);
  }

  /**
   * Removes and returns the element at index i, shifting subsequent elements
   * earlier
   * @param i Index
   * @return Element previously at i
   * @exception IndexOutOfBoundsException If i is not valid, exception
   */
  public E remove(int i) throws IndexOutOfBoundsException {
    checkIndex(i, size);
    E temp = data[i];
    for(int j = i; j < size-1; ++j)
      data[j] = data[j+1];
    data[size-1] = null;
    --size;
    return temp;
  }

  /**
   * Empty the list
   */
  public void clear() {
    while(!isEmpty())
      remove(size-1);
  }

  /**
   * Construct a clone (copy) of the object.
   * @return New array list object with the same structure. This copy should be
   * shallow, i.e., the individual elements are not cloned.
   */
  public List<E> clone() {
    ArrayList<E> l = new ArrayList<>(data.length);
    for(int i = 0; i < size; ++i)
      l.data[i] = data[i];
    l.size = size;
    return l;
  }

  //----------------------------------------------------------------------------
  //-- Private helper methods
  //----------------------------------------------------------------------------
  /**
   * Check validity for a given index
   * @param i Index
   * @param sz Upper limit of index
   * @exception IndexOutOfBoundsException If i is not valid, exception
   */
  private void checkIndex(int i, int sz) throws IndexOutOfBoundsException {
    //check index
    if(i < 0 || i >= sz)
      throw new IndexOutOfBoundsException("Illegal index: " + i);
  }

  /**
   * Resize array to have a new capacity
   * @param c New capacity
   */
  @SuppressWarnings("unchecked")
  private void resize(int c) {
    E[] temp = (E[])new Object[c];
    for(int i = 0; i < size; ++i)
      temp[i] = data[i];
    data = temp;
  }

  /**
   * Inserts element e to be at index i, shifting all subsequent elements later.
   * This method will increment by the parameter if capacity is reached
   * @param i Index
   * @param e New element
   * @param c New capacity
   * @exception IndexOutOfBoundsException If i is not valid, exception
   */
  public void add(int i, E e, int c) throws IndexOutOfBoundsException {
    checkIndex(i, size+1);
    if(size == data.length)
      resize(c);
    for(int j = size-1; j >= i; --j)
      data[j+1] = data[j];
    data[i] = e;
    ++size;
  }
}
