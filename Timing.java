//Name:Alex Kiiru
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Example timing analysis for LinkedList add to random location
 */
public class Timing {
  /**
   * Timing function for LinkedList add to end
   * @param n Size of experiment
   * @param repeats Number of times to repeat experiment
   * @return Seconds taken for experiment
   */
  public static double TimeLinkedListAdd(int n, int repeats) {

    long start = System.nanoTime();

    for(int k = 0; k < repeats; ++k) {
      LinkedList<Integer> l = new LinkedList<>();
      for(int i = 0; i < n; ++i)
        l.add(l.size(), 0);
    }

    long stop = System.nanoTime();
    double sec = (stop - start)/(double)1e9/repeats; //average elapsed time
    return sec;
  }

  /**
   * Run all timing functions and output to terminal and csv file
   * @param args Command-line arguments. Ignored here.
   * @exception FileNotFoundException If system cannot open filename, exception.
   */
  public static void main(String[] args) throws FileNotFoundException {
    PrintWriter pw = new PrintWriter("data_lists.csv");
    System.out.printf("%10s %15s\n", "N", "Time");
    pw.println("N,Time");

    int N = 20000;
    for(int n = 2; n < N; n*=2) {
      System.out.printf("%10s ", n);
      pw.print(n);
      int repeats = Math.max(10, N/n);

      double tall = TimeLinkedListAdd(n, repeats);
      System.out.printf("%15e", tall);
      pw.print("," + tall);

      System.out.println();
      pw.println();
    }
    pw.flush();
    pw.close();
  }
}
