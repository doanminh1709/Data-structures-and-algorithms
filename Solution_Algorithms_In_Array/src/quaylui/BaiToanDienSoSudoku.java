package quaylui;

import java.util.Arrays;

public class BaiToanDienSoSudoku {

  static int[][] sudokuBoard;
  static boolean[][][] markMatrix;
  static boolean[][] markRow;
  static boolean[][] markCol;

  public static void main(String[] args) {
    sudokuBoard = new int[][]{
        {3, 7, 8,  9, 2, 6,  4, 1, 5},
        {4, 2, 9,  1, 5, 0,  0, 6, 0},
        {5, 6, 1,  3, 4, 0,  9, 2, 0},

        {1, 9, 6,  7, 0, 5,  2, 8, 4},
        {7, 4, 5,  2, 8, 1,  0, 9, 0},
        {0, 0, 2,  4, 6, 9,  0, 5, 7},

        {9, 8, 4,  5, 1, 3,  6, 7, 2},
        {2, 5, 7,  6, 9, 4,  0, 3, 1},
        {6, 1, 3,  8, 7, 2,  5, 4, 0}};

    markMatrix = new boolean[3][3][9];
    markRow = new boolean[9][9];
    markCol = new boolean[9][9];

    for (int i = 0; i < sudokuBoard.length; i++) {
      for (int j = 0; j < sudokuBoard[i].length; j++) {
        int currentNumber = sudokuBoard[i][j];
        //Danh dau nhung con so co san , nhung vi tri ma khong co so thi se là so 0
        if (currentNumber != 0) {
          markRow[i][currentNumber - 1] = true;//danh dau la tren hang da co con so nay
          markCol[j][currentNumber - 1] = true;//danh dau tren cot da co con so nay
          markMatrix[i / 3][j / 3][currentNumber - 1] = true;//danh dau tren mang con da co con so nay
        }
      }
    }
    Solve(0, 0);
  }

  public static void Solve(int i, int j) {
    if (i < 9 && j < 9) {
      if (sudokuBoard[i][j] == 0) {
        for (int z = 1; z <= 9; z++) {
          if (!markMatrix[i / 3][j / 3][z - 1] && !markRow[i][z - 1] && !markCol[j][z - 1]) {
            markMatrix[i / 3][j / 3][z - 1] = true;
            markRow[i][z - 1] = true;
            markCol[j][z - 1] = true;
            sudokuBoard[i][j] = z;
            //Đệ quy đi tới cột tiếp theo
            Solve(i, j + 1);
            //Xét tất cả trường hợp không thỏa mãn thì nó sẽ quay lại bước trước đó và 1 cấu hình khác
            //không tìm được cấu hình nào phù hơp thì ta phải set lại cái cấu hình trước đó
            markMatrix[i / 3][j / 3][z - 1] = false;
            markRow[i][z - 1] = false;
            markCol[j][z - 1] = false;
            sudokuBoard[i][j] = 0;
          }
        }
      } else {
        Solve(i, j + 1);
      }
    } else if (i < 9)
      Solve(i + 1, 0);
    else {
      printResult();
    }
  }

  private static void printResult() {
    for (int[] ints : sudokuBoard) {
      System.out.println(Arrays.toString(ints));
    }
  }
}
