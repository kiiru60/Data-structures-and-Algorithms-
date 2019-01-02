/**
 * Unit tests for stack methods
 */
public class TestStack {

  /**
   * Unit test for top method
   * @return Test passed
   */
  public static boolean testTop() {
    //Setup
    Stack<Integer> s = new Stack<>();
    s.push(12);
    s.push(2);
    s.push(5);
    //Execute
    Integer i = s.top();
    //Test
    return i == 5;
    //Tear down
  }

  /**
   * Unit test for push method
   * @return Test passed
   */
  public static boolean testPush() {
    //Setup
    Stack<Integer> s = new Stack<>();
    s.push(12);
    s.push(2);
    s.push(5);
    //Execute
    s.push(4);
    //Test
    return s.size() == 4 && s.top() == 4;
    //Tear down
  }

  /**
   * Unit test for pop method
   * @return Test passed
   */
  public static boolean testPop() {
    //Setup
    Stack<Integer> s = new Stack<>();
    s.push(12);
    s.push(2);
    s.push(5);
    //Execute
    Integer i = s.pop();
    //Test
    return i == 5 && s.size() == 2;
    //Tear down
  }

  /**
   * Unit test for clear method
   * @return Test passed
   */
  public static boolean testClear() {
    //Setup
    Stack<Integer> s = new Stack<>();
    s.push(12);
    s.push(2);
    //Execute
    s.clear();
    //Test
    return s.isEmpty();
    //Tear down
  }

  /**
   * Unit test for clone method
   * @return Test passed
   */
  public static boolean testClone() {
    //Setup
    Stack<Integer> s = new Stack<>();
    s.push(10);
    s.push(1);
    //Execute
    Stack<Integer> s2 = s.clone();
    //Test
    boolean passed = s.size() == s2.size();
    while(!s.isEmpty() && !s2.isEmpty())
      if(s.pop() != s2.pop())
        passed = false;
    return passed;
    //Tear down
  }
}
