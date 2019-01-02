/**
 * Unit tests for array list methods
 */
public class TestArrayList {

  /**
   * Unit test for get method
   * @return Test passed
   */
  public static boolean testGet() {
    //Setup
    ArrayList<Integer> l = new ArrayList<>();
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
    ArrayList<Integer> l = new ArrayList<>();
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
    ArrayList<Integer> l = new ArrayList<>();
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
    ArrayList<Integer> l = new ArrayList<>();
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
    ArrayList<Integer> l = new ArrayList<>();
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
    ArrayList<Integer> l = new ArrayList<>();
    l.add(0, 10);
    l.add(0, 1);
    //Execute
    ArrayList<Integer> l2 = (ArrayList<Integer>)l.clone();
    //Test
    boolean passed = l.size() == l2.size();
    for(int i = 0; i < l.size(); ++i)
      if(l.get(i) != l2.get(i))
        passed = false;
    return passed;
    //Tear down
  }
}
