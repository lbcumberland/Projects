import java.util.*;
import java.lang.*;
import java.io.*;

class Quicksort {

  public static void quickSort(int array[]) {
    doQuickSort(array, 0, array.length-1);
  }

  private static void doQuickSort(int array[], int start, int end) {
    int pivotPoint;

    if (start < end) {
      pivotPoint = partition(array, start, end);

      doQuickSort(array, start, pivotPoint - 1);

      doQuickSort(array, pivotPoint + 1, end);
    }
  }

  private static int partition(int array[], int start, int end) {
    int pivotValue;
    int endOfLeftList;
    int mid;

    mid = (start + end) / 2;

    swap(array, start, mid);

    pivotValue = array[start];

    endOfLeftList = start;

    for (int scan = start + 1; scan <= end; scan++) {
      if (array[scan] < pivotValue) {
        endOfLeftList++;
        swap(array, endOfLeftList, scan);
      }
    }

    swap(array, start, endOfLeftList);

    return endOfLeftList;
  }

  private static void swap(int[] array, int a, int b) {
    int temp;

    temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

  public static void main(String[] args) throws Exception{
    //int[] values = { 5, 1, 3, 6, 4, 2 };
    File file = new File(args[0]); //path leading to .txt file
    Scanner sc = new Scanner(file); //scanner to read file
    int elements = 0; //int var for gathering amount of elements in file
    // read amount of elements in file & enter elements into array
    while (sc.hasNext()) {
      elements++;
      sc.nextInt();
    }
    sc.close();
    Scanner inputs = new Scanner(file);
    int[] array = new int[elements];
    for (int i = 0; inputs.hasNext(); i++) {
      array[i] = inputs.nextInt();
    }

    System.out.println("Original order:");
    for (int element : array)
      System.out.print(element + " ");

    Quicksort.quickSort(array);

    System.out.println("\nSorted order:");
    for (int element : array)
      System.out.print(element + " ");

    System.out.println();
  }
}
