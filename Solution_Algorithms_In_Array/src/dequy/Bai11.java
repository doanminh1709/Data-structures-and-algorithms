package dequy;

import java.util.Scanner;

public class Bai11 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int[][] arr = new int[n][n];
    int value = 1;
    createSpiralMatrix(arr, 0, n, 0, n, value);
    showResult(arr);
  }
  private static void showResult(int[][] arr) {
    for (var row : arr) {
      for (var e : row) {
        System.out.printf("%5d", e);
      }
      System.out.println("\n");
    }
  }
  static void createSpiralMatrix(int[][] a, int rowStart, int rowEnd,
                                 int colStart, int colEnd, int value) {
    if (rowStart >= rowEnd || colStart >= colEnd) {
      return;
    }
    //Gan gia tri cho hang dau tien tu colStart -> colEnd
    for (int i = colStart; i < colEnd; i++) {
      a[rowStart][i] = value++;
    }
    rowStart++;

    for (int i = rowStart ; i < rowEnd; i++) {
      a[i][colEnd-1] = value++;
    }
    colEnd--;

    //Cập nhật hàng cuối
    if (rowStart <= rowEnd) {
      for (int i = colEnd - 1; i >= colStart ; i--) {
        a[rowEnd-1][i] = value++;
      }
      rowEnd--;
    }
    //Cập nhật cột đầu
    if (colStart <= colEnd) {
      for (int i = rowEnd - 1; i >= rowStart; i--) {
        a[i][colStart] = value++;
      }
      colStart++;
    }
    createSpiralMatrix(a, rowStart, rowEnd, colStart, colEnd, value);
  }
}
