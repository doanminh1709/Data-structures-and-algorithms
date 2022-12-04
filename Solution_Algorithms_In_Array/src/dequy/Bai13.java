package dequy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai13 {
  public static void main(String[] args) {
    String inputFile = "src/file/input1.txt";
    Scanner input;
    try { // thay bằng input của bạn. Sinh data từ bài tập số 11 rồi pate vào nhé!
      input = new Scanner(new File(inputFile));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return; // end game
    }
    //Doc input ra file
    int[][] arr;
    int row, col;
    row = input.nextInt();
    col = input.nextInt();
    arr = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        arr[i][j] = input.nextInt();
      }
    }
      int rowEnd = arr.length;
      int colEnd = arr[0].length;
      int rowStart = 0, colStart = 0;
      show(arr, colStart, colEnd, rowStart, rowEnd);
    }

  public static void show(int[][] arr, int colStart, int colEnd, int rowStart, int rowEnd) {

    if (colStart >= colEnd || rowStart >= rowEnd) {
      return;
    }
    //In hang dau tien
    for (int i = colStart; i < colEnd; i++) {
      System.out.print(arr[rowStart][i] + " ");
    }
    rowStart++;

    //In cot cuoi cung
    for (int i = rowStart; i < rowEnd; i++) {
      System.out.print(arr[colEnd - 1][i] + " ");
    }
    colEnd--;
    //In ra hang cuoi len
    if (rowStart < rowEnd) {
      for (int i = colEnd - 1; i >= colStart; i--) {
        System.out.print(arr[rowEnd - 1][i] + " ");
      }
      rowEnd--;
    }

    //In ra cot dau len
    if (colStart < colEnd) {
      for (int i = rowEnd - 1; i >= rowStart; i--) {
        System.out.print(arr[i][colStart] + " ");
      }
      colStart++;
    }
    show(arr, colStart, colEnd, rowStart, rowEnd);
  }

}
