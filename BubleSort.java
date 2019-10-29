import java.util.*;
import java.lang.*;
import java.io.*;

class BubleSort {
  //Bubble Sort
  void bubbleSort(int[] array) {
    int bound = array.length;
    for (int i = 0; i < bound - 1; i++) {
      for (int j = 0; j < bound - i - 1; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j+1];
          array[j+1] = temp;
          //mySwapArray(array, j, (j+1));
        }
      }
    }
  }
  //swap array
  void mySwapArray(int[] a, int b, int c) {
    int temp = a[b];
    a[b] = a[c];
    a[c] = temp;
  }
  //print array
  void printArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (i == (array.length - 1)) {
        System.out.print(array[i]);
      } else
        System.out.print(array[i] + " ");
    }
    System.out.println();
  }
  //main
  public static void main(String[] args) throws Exception{
    File file = new File(args[0]);
    Scanner sc = new Scanner(file);
    int elements = 0;
    //read from file and write to array
    while (sc.hasNext()) {
      sc.nextInt();
      elements++;
    }
    sc.close();
    Scanner inputs = new Scanner(file);
    int[] array = new int[elements];
    for (int i = 0; i < elements; i++) {
      array[i] = inputs.nextInt();
    }
    inputs.close();
    //create object to implement method
    BubleSort bs = new BubleSort();
    //print unsorted array
    //System.out.println(Arrays.toString(array));
    //sorting method
    bs.bubbleSort(array);
    //print sorted array
    bs.printArray(array);
    //System.out.println(Arrays.toString(array));
  }
}
