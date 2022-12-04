package quaylui;

import java.util.Arrays;

public class BaiToanXepHau {

  private static final int N = 8;

  public static void main(String[] args) {
    //Ý tưởng của đệ quy là mình sẽ đi tìm thử tất cả các trường hợp cho đến khi tìm được lời giải
    //Nếu một trường hợp mà không thể phát triển k thể đi đến được kết quả thì mình sẽ quay trở lại bước trước đó

    //Đầu tiên mình sẽ đi tìm cột trái cùng
    //Nếu cả 8 con hậu được xếp vào bàn cờ thì coi như đã tìm được lời giải , return true
    //Thử tất cả các hàng và cột hiện thời
    //Nếu quân hậu có thể điền vào hàng này thì sẽ đánh dấu lại
    //Tiếp tục để quy xem trường hợp tiếp theo có thể tìm được lời giải hay không
    //Nếu đặt hậu ở vị trí hiện thời không tìm được lời giải thì mình sẽ quay trở về cột phía trước và lặp lại quá
    //trình này.
    //Nếu tất cả các hàng đã được thử và k tìm thấy lời giải thì trả về false
    int[][] board = new int[N][N];
    if (solve(board, 0)) {
      showInfo(board);
    } else {
      System.out.println("No solution");
    }
  }

  public static boolean solve(int[][] board, int col) {
    if (col >= N) {
      return true;
    } else {
      for (int i = 0; i < N; i++) {
        if (isSafe(board, i, col)) {
          board[i][col] = 1;
          if (solve(board, col + 1)) {
            return true;
          } else {
            board[i][col] = 0;
          }
        }
      }
    }
    return false;
  }

  public static boolean isSafe(int[][] board, int row, int col) {
    //Kiem tra hang
    for (int i = 0; i < col; i++) {
      if (board[row][i] == 1) return false;
    }
    //Kiem tra duong cheo tren
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 1) return false;
    }

    //Kiem tra duong cheo duoi
    for (int i = row, j = col; i < N && j >= 0; i++, j--) {
      if (board[i][j] == 1) return false;
    }
    return true;
  }

  public static void showInfo(int[][] board) {
    for (int[] ints : board) {
      System.out.println(Arrays.toString(ints));
    }
    System.out.println();
  }
}
