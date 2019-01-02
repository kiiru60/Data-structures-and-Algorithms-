/**
 * Unit tests for queue methods
 */
public class TestQueue {

  /**
   * Unit test for first method
   * @return Test passed
   */
  public static boolean testFirst() {
    //Setup
    Queue<Integer> q = new Queue<>();
    q.enqueue(12);
    q.enqueue(2);
    q.enqueue(5);
    //Execute
    Integer i = q.first();
    //Test
    return i == 12;
    //Tear down
  }

  /**
   * Unit test for enqueue method
   * @return Test passed
   */
  public static boolean testEnqueue() {
    //Setup
    Queue<Integer> q = new Queue<>();
    q.enqueue(12);
    q.enqueue(2);
    q.enqueue(5);
    //Execute
    q.enqueue(4);
    //Test
    return q.size() == 4;
    //Tear down
  }

  /**
   * Unit test for dequeue method
   * @return Test passed
   */
  public static boolean testDequeue() {
    //Setup
    Queue<Integer> q = new Queue<>();
    q.enqueue(12);
    q.enqueue(2);
    q.enqueue(5);
    //Execute
    Integer i = q.dequeue();
    //Test
    return i == 12 && q.size() == 2;
    //Tear down
  }

  /**
   * Unit test for clear method
   * @return Test passed
   */
  public static boolean testClear() {
    //Setup
    Queue<Integer> q = new Queue<>();
    q.enqueue(12);
    q.enqueue(2);
    //Execute
    q.clear();
    //Test
    return q.isEmpty();
    //Tear down
  }

  /**
   * Unit test for clone method
   * @return Test passed
   */
  public static boolean testClone() {
    //Setup
    Queue<Integer> q = new Queue<>();
    q.enqueue(10);
    q.enqueue(1);
    //Execute
    Queue<Integer> q2 = q.clone();
    //Test
    boolean passed = q.size() == q2.size();
    while(!q.isEmpty() && !q2.isEmpty())
      if(q.dequeue() != q2.dequeue())
        passed = false;
    return passed;
    //Tear down
  }
}
