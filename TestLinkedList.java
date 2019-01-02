/**
 * Unit tests for linked list methods
 */
public class TestLinkedList {

  /**
   * Unit test for get method
   * @return Test passed
   */
  public static boolean testGet() {
    //Setup
    LinkedList<Integer> l = new LinkedList<>();
    l.add(0, 12);
    l.add(0, 2);
    l.add(0, 5);
    //Execute
    Integer i = l.get(1);
    //Test
    return i == 2;
    //Tear down
  }

  /**
   * Unit test for set method
   * @return Test passed
   */
  public static boolean testSet() {
    //Setup
    LinkedList<Integer> l = new LinkedList<>();
    l.add(0, 12);
    l.add(0, 2);
    l.add(0, 5);
    //Execute
    Integer i = l.set(2, 4);
    //Test
    return i == 12 && l.get(2) == 4;
    //Tear down
  }

  /**
   * Unit test for add method
   * @return Test passed
   */
  public static boolean testAdd() {
    //Setup
    LinkedList<Integer> l = new LinkedList<>();
    l.add(0, 12);
    l.add(0, 2);
    l.add(0, 5);
    //Execute
    l.add(2, 4);
    //Test
    return l.size() == 4 && l.get(2) == 4;
    //Tear down
  }

  /**
   * Unit test for remove method
   * @return Test passed
   */
  public static boolean testRemove() {
    //Setup
    LinkedList<Integer> l = new LinkedList<>();
    l.add(0, 12);
    l.add(0, 2);
    l.add(0, 5);
    //Execute
    Integer i = l.remove(1);
    //Test
    return i == 2 && l.size() == 2;
    //Tear down
  }

  /**
   * Unit test for clear method
   * @return Test passed
   */
  public static boolean testClear() {
    //Setup
    LinkedList<Integer> l = new LinkedList<>();
    l.add(0, 12);
    l.add(0, 2);
    //Execute
    l.clear();
    //Test
    return l.isEmpty();
    //Tear down
  }

  /**
   * Unit test for clone method
   * @return Test passed
   */
  public static boolean testClone() {
    //Setup
    LinkedList<Integer> l = new LinkedList<>();
    l.add(0, 10);
    l.add(0, 1);
    //Execute
    LinkedList<Integer> l2 = (LinkedList<Integer>)l.clone();
    //Test
    boolean passed = l.size() == l2.size();
    for(int i = 0; i < l.size(); ++i)
      if(l.get(i) != l2.get(i))
        passed = false;
    return passed;
    //Tear down
  }
}
