package thuattoansinh.hoanviketiep;

import java.util.Scanner;

public class Bai2 {

  public static boolean nextGenerate(int[] arr) {

    int j = arr.length - 2;
    while (j >= 0 && arr[j] >= arr[j + 1]) {
      j--;
    }

    if (j >= 0) {
      int k = arr.length - 1;
      while (arr[j] > arr[k]) {//Tim vi tri phan tu be nhat trong mang
        k--;
      }
      int item = arr[j];
      arr[j] = arr[k];
      arr[k] = item;

      //dao lai vi tri tu sau i den n - 1
      int r = j + 1;
      int d = arr.length - 1;
      while (r < d) {
        item = arr[r];
        arr[r] = arr[d];
        arr[d] = item;
        r++;
        d--;
      }
      return false;
    } else {
      return true;
    }
  }

  public static void generate(int[] arr) {
    int cnt = 1;
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) cnt++;
    }
    if (cnt == arr.length) {
      System.out.println("UNAVAILABLE");
    } else {
      boolean isCheck = nextGenerate(arr);
      if (!isCheck) {
        output(arr);
      }
    }
  }

  public static void output(int[] arr) {
    for (int item : arr) {
      System.out.print(item + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++)
        arr[i] = sc.nextInt();
      generate(arr);
      t--;
    }
  }
}
