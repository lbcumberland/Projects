import java.util.Scanner;
class RemoveOneNode {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Node head = new Node(in.nextLine());
    Node current = head;
    while (true) {
      String s = in.nextLine();
      if (s.compareTo("END") == 0) break;
      else {
        current.next = new Node(s);
        current.next.prev = current;
        current = current.next;
      }
    }
    current = head;
    int count = 0;
    while (current != null) {
      if (count == 2) {
        current.prev.next = current.next;
        current = current.next;
        if (current != null) current.prev = current.prev.prev;
        break;
      } else {
        current = current.next;
        count++;
      }
    }
    current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
    System.out.println("");
  }
}
