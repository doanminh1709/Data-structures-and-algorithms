package thuattoansinh.tohopchapk;

import java.util.Scanner;

public class Bai1 {
  public static boolean nextGenerate(int[] arr, int n) {

    int i = arr.length - 1;//Xuất phát từ phần tử cuối của tập hợp
    int k = arr.length;//lấy ra số phần tử của mảng

//    3 4 5 : n = 5 i = 2 k = 3
//    5 - 3 + 2 + 1 = 5
//    5 - 3 + 1 + 1 = 4
//    5 - 3 + 1 + 0 = 3
    while (i >= 0 && arr[i] == n - k + i + 1) {
      //lay ra phan tu dau tien arr[i] khác n - k + i + 1
      i--;
    }
    if (i >= 0) {//nếu mà chưa vượt qua phần tử trái cùng
      arr[i] = arr[i] + 1; // Tăng giá trị của phần tử tại vị trí i vì nó vẫn nhở hơn n - k + i - 1
      for (int j = i + 1; j < k; j++) {//Cập nhật lại các phần tử i + 1 đến k
        arr[j] = arr[i] + j - i;//Nếu các giá trị arr[j] chưa phải cấu hình cuối thì mk vẫn tt cập nhật
      }
      return false;//i >= 0 chứng ta đang còn cấu hình
    } else {
      return true;// hết cấu hình để tìm
    }
  }

  public static void generate(int[] arr, int n) {
    boolean isMark = false;
    while (!isMark) {
      output(arr);
      isMark = nextGenerate(arr, n);
    }
  }

  public static void output(int[] arr) {
    for (int item : arr) {
      System.out.print(item + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    while (t > 0) {
      int n = scanner.nextInt();
      int k = scanner.nextInt();
      int[] arr = new int[k];
      for (int i = 0; i < k; i++)
        arr[i] = i + 1;
      generate(arr, n);
      t--;
    }
  }
}
