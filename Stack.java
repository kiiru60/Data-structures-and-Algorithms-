//Name:
import java.lang.IndexOutOfBoundsException;

/**
 * Stack ADT from Chapter 6.1 with the addition of clear and clone implemented
 * with an ArrayList
 * @param <E> Element type
 */
public class Stack<E> {

  //----------------------------------------------------------------------------
  //-- Private data
  //----------------------------------------------------------------------------

  /**
   * ArrayList storage
   */
  private ArrayList<E> stack;

  //----------------------------------------------------------------------------
  //-- Public methods
  //----------------------------------------------------------------------------

  /**
   * Construct empty stack
   */
  public Stack() {
    stack = new ArrayList<E>();
  }

  /**
   * Return number of elements in the stack
   * @return Number of elements
   */
  int size() {
    return stack.size();
  }

  /**
   * Returns whether the stack is empty
   * @return True if the stack is empty, false otherwise
   */
  boolean isEmpty() {
    return stack.isEmpty();
  }

  /**
   * Returns the top element
   * @return Element on top
   */
  E top() {
    return stack.get(stack.size() - 1);
  }

  /**
   * Inserts element e into stack
   * @param e New element
   */
  void push(E e) {
    stack.add(stack.size(), e);
  }

  /**
   * Removes top element from stack
   * @return Element previously on top
   */
  E pop() {
    return stack.remove(stack.size() - 1);
  }

  /**
   * Empty the stack
   */
  public void clear() {
    stack.clear();
  }

  /**
   * Construct a clone (copy) of the object.
   * @return New stack object with the same structure. This copy should be
   * shallow, i.e., the individual elements are not cloned.
   */
  public Stack<E> clone() {
    Stack<E> s = new Stack<>();
    s.stack = (ArrayList<E>)stack.clone();
    return s;
  }
}
