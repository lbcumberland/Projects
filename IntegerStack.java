import java.util.*;
public class IntegerStack {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.add(10);
    stack.add(20);
    stack.add(1, 100); //we can add at a position

    for (int value : stack) {
      System.out.println(value);
    }
  }
}
