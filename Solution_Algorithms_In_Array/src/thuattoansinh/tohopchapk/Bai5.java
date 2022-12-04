package thuattoansinh.tohopchapk;

import java.util.Scanner;

public class Bai5 {

  public static boolean nextGenerate(int[] arr, int n) {
    int i = arr.length - 1;
    int k = arr.length;

    while (i >= 0 && arr[i] == n - k + i + 1) {
      i--;
    }
    if (i >= 0) {
      arr[i] = arr[i] + 1;
      for (int j = i + 1; j < k; j++) {
        arr[j] = arr[i] + j - i;
      }
      return false;
    } else {
      return true;
    }
  }

  public static void generate(int[] arr, int k, int n, int S) {

    int[] subnet = new int[k];
    for (int i = 0; i < subnet.length; i++) {
      subnet[i] = i + 1;// Ta sẽ thêm 1 bảng nữa là bảng subnet làm bảng vị trí mà in ra từ 1 đến n
    }
    int count = 0;
    boolean isCheck = false;
    while (!isCheck) {
      if (sum(arr, subnet) == S) {
        output(arr, subnet);
        count++;
      }
      isCheck = nextGenerate(subnet, n);
    }
    if (count == 0) {
      System.out.println("NO RESULT");
    }
  }

  public static void output(int[] arr, int[] subnet) {
    for (int j : subnet) {
      System.out.print(arr[j - 1] + " ");
    }
    System.out.println();

  }

  public static int sum(int[] arr, int[] subnet) {
    int sum = 0;
    for (int i = 0; i < subnet.length; i++) {
      sum += arr[subnet[i] - 1];
    }
    return sum;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int S = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++)
        arr[i] = sc.nextInt();
      generate(arr, k, n, S);
    }
  }

}
