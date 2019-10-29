import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
class Merge {
  // Insertion Sort (for integers, ascending order)
  public int[] sortIntArray(int[] array) {
      for (int j = 1; j < array.length; j++) {
          int key = array[j];
          int i = j - 1;
          while (i >= 0 && array[i] > key) {
              array[i + 1] = array[i];
              i--;
          }
          array[i + 1] = key;
      }
      return array;
  }

  // Insertion Sort (for integers, descending order)
  public int[] sortIntArrayDesc(int[] array) {
      for (int j = 1; j < array.length; j++) {
          int key = array[j];
          int i = j - 1;
          while (i >= 0 && array[i] < key) {
              array[i + 1] = array[i];
              i--;
          }
          array[i + 1] = key;
      }
      return array;
  }


  // my merge method
  //NO SORTING IN THE MERGE METHOD
  /*public int[] myMerge(int[] A, int[] B, int e) {
    int counter = 0;
    int[] finalized = new int[e];
    //if statement to determine order
    for (int i = 0; i < A.length; i++) {
      finalized[i] = A[i];
      counter++;
    }
    for (int j = 0; j < B.length; j++) {
      finalized[counter++] = B[j];
    }

    //Merge newMerge = new Merge();
    //int[] finished = newMerge.sortIntArrayDesc(finalized);
    //return finished;
    return finalized;
  }*/


  //my revised merge
  public int[] myNewMerge(int[] a, int[] b, int c) {
    int[] d = new int[c];
    int i = 0;
    int j = a.length-1;
    int k = 0;
    //a is descending
    //b is ascending

    //for (int i = 0; i < c; i++) {
    while (i < c && (j >= 0 || k <= b.length-1)){
      if (a[j] >= b[k]) {
        d[i] = a[j];
        if (j > 0) {
          j--;
        }
      } else if (a[j] < b[k]) {//if (a[j] < b[k]) {
        d[i] = b[k];
        if (k < b.length-1) {
          k++;
        }
      }
      i++;
    }
    return d;
  }

  // main
  public static void main(String[] args) throws Exception{

    int elements = 0;
    int elements_2 = 0;

    File file = new File(args[0]);
    File file_2 = new File(args[1]);

    Scanner sc = new Scanner(file);
    Scanner sc_2 = new Scanner(file_2);

    while (sc.hasNextLine()) {
      sc.nextLine();
      elements++;
    }
    sc.close();

    while (sc_2.hasNextLine()) {
      sc_2.nextLine();
      elements_2++;
    }
    sc_2.close();

    int[] array = new int[elements];
    Scanner in = new Scanner(file);
    for (int i = 0; in.hasNext(); i++) {
      array[i] = Integer.parseInt(in.nextLine());
    }
    in.close();

    int[] array_2 = new int[elements_2];
    Scanner in_2 = new Scanner(file_2);
    for (int i = 0; in_2.hasNext(); i++) {
      array_2[i] = Integer.parseInt(in_2.nextLine());
    }
    in_2.close();

    Merge merge = new Merge();
    int[] sort = merge.sortIntArray(array);

    Merge merge_2 = new Merge();
    int[] sort_2 = merge.sortIntArrayDesc(array_2);
    //SORTING DONE BEFORE MERGE METHOD
    //Merge merge_final = new Merge();
    Merge end = new Merge();
    int[] finished = end.myNewMerge(sort, sort_2, (elements+elements_2));

    for (int i = 0; i < sort.length; i++) {
      if (i == (sort.length-1)) {
        System.out.print(sort[i]);
      } else
        System.out.print(sort[i] + " ");
    }
    System.out.println();

    for (int i = 0; i < sort_2.length; i++) {
      if (i == (sort_2.length-1)) {
        System.out.print(sort_2[i]);
      } else
        System.out.print(sort_2[i] + " ");
    }
    System.out.println();

    for (int i = 0; i < finished.length; i++) {
      if (i == (finished.length-1)) {
        System.out.print(finished[i]);
      } else
        System.out.print(finished[i] + " ");
    }
  }
}
