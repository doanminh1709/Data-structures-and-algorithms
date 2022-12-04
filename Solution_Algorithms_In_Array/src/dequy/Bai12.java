package dequy;

import java.util.Scanner;

public class Bai12 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int[][] arr = new int[n][n];
    int value = n * n;
    createSpiralMatrixReverse(arr, 0, n, 0, n, value);
    output(arr);
  }

  public static void output(int[][] arr) {
    for (var item : arr) {
      for (int i : item) {
        System.out.printf("%5d", i);
      }
      System.out.println();
    }
  }

  public static void createSpiralMatrixReverse(int[][] arr, int rowStart,
                                               int rowEnd, int colStart,
                                               int colEnd, int value) {
    if (colEnd <= colStart || rowStart >= rowEnd || value <= 0) {
      return;
    }
    //Cập nhật hàng đầu tiên
    for (int i = colEnd - 1; i >= colStart; i--) {
      arr[rowStart][i] = value--;
    }
    rowStart++;

    //Cập nhật cột đầu tiên
    for (int i = rowStart; i < rowEnd; i++) {
      arr[i][colStart] = value--;
    }
    colStart++;

    //Cập nhật hàng cuối
    if (rowStart <= rowEnd) {
      for (int i = colStart; i < colEnd; i++) {
        arr[rowEnd - 1][i] = value--;
      }
      rowEnd--;
    }
    //Cập nhật cột cuối
    if (colEnd >= colStart) {
      for (int i = rowEnd-1; i >= rowStart; i--) {
        arr[i][colEnd - 1] = value--;
      }
      colEnd--;
    }
    createSpiralMatrixReverse(arr, rowStart, rowEnd,
        colStart, colEnd, value);
  }
}
