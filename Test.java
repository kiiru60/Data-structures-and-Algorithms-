import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Run all Unit Tests for Assignment 1
 */
public class Test {
  /**
   * Run all tests within a testing unit
   * @param <T> Testing Unit type
   * @param t Testing Unit instance
   * @return All tests of unit passed
   */
  public static <T> boolean test(T t) {
    boolean succ = true;
    Method[] methods = t.getClass().getDeclaredMethods();
    for(Method m : methods) {
      System.out.printf("Test %20s passed? ", m.getName());
      try {
        boolean res =  ((Boolean)m.invoke(t)).booleanValue();
        System.out.printf("%10s\n", res);
        succ = succ && res;
      }
      catch(InvocationTargetException e) {
        System.out.println("Test broken..." + e.getCause());
        succ = false;
      }
      catch(Exception e) {
        System.out.println("Test broken..." + e);
        succ = false;
      }
    }
    return succ;
  }

  /**
   * Run all testing units
   * @param args Command-line arguments are unused
   */
  public static void main(String[] args) {
    boolean res = true;

    System.out.println("\n\nTesting LinkedList");
    res = test(new TestLinkedList());
    System.out.println("passed? " + res);

    System.out.println("\n\nTesting ArrayList");
    res = test(new TestArrayList());
    System.out.println("passed? " + res);

    System.out.println("\n\nTesting Stack");
    res = test(new TestStack());
    System.out.println("passed? " + res);

    System.out.println("\n\nTesting Queue");
    res = test(new TestQueue());
    System.out.println("passed? " + res);
  }
}
