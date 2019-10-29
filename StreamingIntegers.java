import java.util.Scanner;
import java.util.PriorityQueue;
class StreamingIntegers {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PriorityQueue<Integer> numbers = new PriorityQueue<>();
    //while (in.hasNextInt()) {
        //numbers.add(in.nextInt());
      //if (in.nextLine().compareTo("END") == 0)

    while (true) {
      String s = in.next();
      if (s.compareTo("END") ==0) break;
      else {
        Scanner second = new Scanner(s);
        numbers.add(second.nextInt());
      }
    }
    in.close();
    while (!numbers.isEmpty()) {
      System.out.println(numbers.remove());
    }
  }
}
