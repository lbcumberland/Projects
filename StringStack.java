import java.util.*;
public class StringStack {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    stack.push("fly");
    stack.push("worm");
    stack.push("butterfly");

    String peekResult = stack.peek();
    System.out.println(peekResult);

    String popResult = stack.pop();
    System.out.println(popResult);

    popResult = stack.pop();
    System.out.println(popResult);
  }
}
