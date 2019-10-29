import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;
class StreamingWords {
  public static void main(String[] args) {
    Comparator<String> test = new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        return s1.length() - s2.length();
      }
    };
    /*
    Comparator<String> test = new Comparator<String>() {
      @Override
      
    };
    */
    Scanner in = new Scanner(System.in);
    PriorityQueue<String> words = new PriorityQueue<>(test);
    while (true) {
      String line = in.nextLine();
      if (line.compareTo("END") == 0) break;
      else {
        words.add(line);
      }
    }
    in.close();
    while (!words.isEmpty()) {
      System.out.println(words.remove());
    }
  }
}
