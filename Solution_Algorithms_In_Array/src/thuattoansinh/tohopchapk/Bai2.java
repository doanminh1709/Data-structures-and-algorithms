package thuattoansinh.tohopchapk;

import java.util.Scanner;

public class Bai2 {
  public static void generate(int[] arr, int n) {
    boolean isCheck = nextGenerate(arr , n);
    if (!isCheck) {
      output(arr, n);
    }else{
      System.out.println("UNAVAILABLE");
    }
  }

  public static boolean nextGenerate(int[] arr, int n) {

    int i = arr.length - 1;//Xuất phát kiểm tra từ phần tử cuối cùng tổ hợp
    int z = arr.length;

    while (i >= 0 && arr[i] == n - z + i + 1) {
      i--;//
    }
    if (i >= 0) {
      arr[i] = arr[i] + 1;
      for (int j = i + 1; j < z; j++) {
        arr[j] = arr[i] + j - i;//cập nhật lại arr[j]
      }
      return false;
    }
    return true;
  }

  public static void output(int[] arr, int n) {
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
      int k = sc.nextInt();
      int[] arr = new int[k];
      for (int i = 0; i < k; i++)
        arr[i] = sc.nextInt();

      generate(arr , n);
      t--;
    }
  }
}
