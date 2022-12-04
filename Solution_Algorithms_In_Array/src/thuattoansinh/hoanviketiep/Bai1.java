package thuattoansinh.hoanviketiep;

import java.util.Scanner;

public class Bai1 {

  private static boolean nextGenerate(int[] arr) {
    int i = arr.length - 2;
    while (i >= 0 && arr[i] > arr[i + 1]) {
      i--;
    }
    if (i >= 0) {
      int b = arr.length - 1;
      while (arr[i] > arr[b]) {
        b--;
      }
      int item = arr[i];
      arr[i] = arr[b];
      arr[b] = item;

      int r = i + 1;
      int k = arr.length - 1;
      while (r < k) {
        int t = arr[r];
        arr[r] = arr[k];
        arr[k] = t;
        r++;
        k--;
      }
      return false;
    } else {
      return true;
    }
  }

  public static void generate(int[] arr) {
    boolean isMark = false;
    while (!isMark) {
      ketQua(arr);
      isMark = nextGenerate(arr);
    }
  }

  public static void ketQua(int[] arr) {
    for (int item : arr) {
      System.out.print(item + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int t = new Scanner(System.in).nextInt();
    while (t > 0) {
      int n = new Scanner(System.in).nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++)
        arr[i] = i + 1;
      generate(arr);
      t--;
    }
  }
}
