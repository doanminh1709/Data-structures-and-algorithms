package thuattoansinh.tohopchapk;

import java.util.Scanner;

public class Bai4 {

  public static boolean nextGenerate(int[] arr, int n) {

    int i = arr.length - 1;//duyệt từ vị trí cuối cùng
    int k = arr.length;

    while (i >= 0 && arr[i] == n - k + i + 1) {
      i--;
    }
    if (i >= 0) {
      //Cập nhật lại các phần từ từ i đến k
      arr[i] = arr[i] + 1;
      for (int j = i + 1; j < k; j++) {
        arr[j] = arr[i] + j - i;
      }
      return false;
    } else {
      return true;
    }
  }

  public static void generate(int[] arr, int n, int S) {

    //Sinh 1 -> n các phần tử để kiểm tra , thì mình phải cập phât n lần
    int count = 0;
    for (int i = 1; i <= n; i++) {
      int[] subnet = new int[i];

      //Khởi tạo những bộ giá trị cho mảng con
      for (int j = 0; j < i; j++) {
        subnet[j] = j + 1;
      }

      boolean isMark = false;
      while (!isMark) {
        if (sum(arr, subnet) == S) {
          output(arr, subnet);
          count++;
        }
        isMark = nextGenerate(subnet, n);
      }
    }
    if (count == 0) {
      System.out.println("NO RESULT");
    }
  }

  public static int sum(int[] arr, int[] subnet) {
    int total = 0;
    for (int i = 0; i < subnet.length; i++) {
      total += arr[subnet[i] - 1];
    }
    return total;
  }

  public static void output(int[] arr, int[] subnet) {
    for (int j : subnet) {
      System.out.print(arr[j - 1] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int t = input.nextInt();
    while (t-- > 0) {
      int n = input.nextInt();
      int S = input.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++)
        arr[i] = input.nextInt();
      generate(arr, n, S);
    }
  }
}
