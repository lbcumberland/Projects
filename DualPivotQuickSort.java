import java.util.*;
import java.io.*;
import java.lang.*;

class DualPivotQuickSort {
  // print array method
  void printArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (i == (array.length - 1)) {
        System.out.print(array[i]);
      } else
        System.out.print(array[i] + " ");
    }
    System.out.println();
  }
  //swap methods
  void mySwapArray(int[] a, int b, int c) {
    int temp = a[b];
    a[b] = a[c];
    a[c] = temp;
  }

  /*void mySwap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
  }*/

  //by the book Yaroslavskiy
  void dpqy(int[] A, int left, int right) {
    //Sort the array A in index range left,...,right.
    if (right - left >= 1) {
      int p = A[left]; int q = A[right]; //p is the first index.
      if (p < q) {int temp = p; p = q; q = temp; mySwapArray(A, left, right);}
      int l = left + 1; int g = right - 1; int k = l; //l = left + 1, is the 2nd index. g = right - 1, is the 2nd to last index.
      while (k <= g) { //Original
        //if (A[k] < p) { //Original is A[1] < A[0]?
        if (A[k] > p) { // k = A[1]. p = A[0].
          //int temp = A[k]; A[k] = A[l]; A[l] = temp;
          mySwapArray(A, k, l); //Original
          l = l + 1;
        } else {
          //if (A[k] > q) { //Original
          if (A[k] < q) {
            //while (A[g] > q && k < g) {g = g - 1;} //Original
            while (A[g] < q && k < g) {g = g - 1;}
            //int temp = A[k]; A[k] = A[g]; A[g] = temp;
            mySwapArray(A, k, g);
            g = g - 1;
            //if (A[k] < p) { //Original
            if (A[k] > p) {
              //int temp = A[k]; A[k] = A[l]; A[l] = temp;
              mySwapArray(A, k, l);
              l = l + 1;
            }
          }
        }
        k = k + 1;
      }
      l = l - 1; g = g + 1;
      //int temp = A[left]; A[left] = A[l]; A[l] = temp;
      mySwapArray(A, left, l);
      //int temp = A[right]; A[right] = A[g]; A[g] = temp;
      mySwapArray(A, right, g);
      dpqy(A, left, l - 1); dpqy(A, l + 1, g - 1); dpqy(A, g + 1, right);
    }
  }

  // can we use a method to read the file and write to an array?
  // Yaroslavskiy, my attempt
  /*void dualPivotQuickSortYaroslavskiy(int[] array, int left, int right) {
    // sort the array "array" in index range "left",...,"right".
    if ((right - left) >= 1) { //right = last index. left = first index.
      int p = array[left]; int q = array[right]; //p is the left pivot, q the right pivot
      //System.out.println(Arrays.toString(array));
      if (p > q) { //is left pivot > right pivot?
        //int temp = array[left]; //if so, swap.
        //array[left] = array[right];
        //array[right] = temp;
        mySwap(p, q);
        mySwapArray(array, left, right);
        //System.out.println("Pivot swap section: " + Arrays.toString(array)); //prints 3 total times
      }
      int l = left + 1; int g = right - 1; int k = l; //l = index 1. g = 2nd to last index. k = index 1.
      while (k <= g) { //k = l, index is 1, so k is 99. g = the second to last index of array, elements -2, is 98.
                       //while (1 <= elements-2 (7 in this case)).
        if (array[k] < p) { //array[1] = 99. array[left] = 21. 99 < 21?
          mySwapArray(array, k, l); //if so, swap them
          //System.out.println("1st if: " + Arrays.toString(array)); // first occurrence of change.
          l = l + 1; //l advances to index 2. [0-(elements-1)]
          //k = k + 1;
        } else
          if (array[k] > q) { //99 < 67?
            while (array[g] > q && k < g) {g = g - 1;} //array[g] = 98. q = 67. k = 1. g = 7.
            mySwapArray(array, k, g);
            //System.out.println("2nd if: " + Arrays.toString(array));
            g = g - 1;
            if (array[k] < p) { //array[k] = 99. array[left] = 21.
              //System.out.println(Arrays.toString(array));
              mySwapArray(array, k, l);
              //System.out.println("3rd if : " + Arrays.toString(array));
              l = l + 1;
            }
          }
        k = k + 1;
        //if (array[k] < p) {k = k + 1;}
      } //end of while
      l = l - 1; g = g + 1;
      //System.out.println(Arrays.toString(array));
      mySwapArray(array, left, l);
      //System.out.println(Arrays.toString(array));
      mySwapArray(array, right, g);
      System.out.println(Arrays.toString(array));
      dualPivotQuickSortYaroslavskiy(array, left, l - 1);
      //System.out.println(Arrays.toString(array));
      dualPivotQuickSortYaroslavskiy(array, l + 1, g - 1);
      //System.out.println(Arrays.toString(array));
      dualPivotQuickSortYaroslavskiy(array, g + 1, right);
      //System.out.println(Arrays.toString(array));
    } //closing outer if
  } *///end of Yaroslavskiy

  //main
  public static void main(String[] args) throws Exception{
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
    //create object
    DualPivotQuickSort dpqs = new DualPivotQuickSort();
    //dpqs.printArray(array); //print before sort
    //System.out.println("Before Yaro: " + Arrays.toString(array));
    dpqs.dpqy(array, 0, elements - 1); //sort
    dpqs.printArray(array); //print after sort
    //System.out.println("After Yaro: " + Arrays.toString(array));
  }
}
