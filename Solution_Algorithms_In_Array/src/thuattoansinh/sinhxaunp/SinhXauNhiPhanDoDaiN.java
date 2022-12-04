package thuattoansinh.sinhxaunp;

import java.util.Scanner;

public class SinhXauNhiPhanDoDaiN {

  public static void generate(int[] arr) {
    boolean isMark = false;
    while (!isMark) {
      output(arr);
      isMark = nextGenerateString(arr);
    }
  }

  private static boolean nextGenerateString(int[] arr) {
    int i = arr.length - 1;
    while (i >= 0 && arr[i] != 0) {
      arr[i] = 0;
      i--;
    }
    if (i >= 0) {
      arr[i] = 1;
      return false;
    } else {
      return true;
    }
  }

  private static void output(int[] arr) {
    for (var i : arr)
      System.out.print(i);
    System.out.println();
  }

  public static void main(String[] args) {

    int n = new Scanner(System.in).nextInt();
    int[] arr = new int[n];

    generate(arr);
  }
}
