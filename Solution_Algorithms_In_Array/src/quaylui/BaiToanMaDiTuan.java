package quaylui;

public class BaiToanMaDiTuan {
  /*
  B1: Xuất phát từ ô đầu tiên trên bàn cờ.
  B2: Nếu tất cả các ô trên bàn cờ đã được ghé thăm, in ra kết quả.
  B3: Nếu không:
  B3.1: Thêm bước đi kế tiếp(phần tử) vào mảng kết quả.
  B3.2: Gọi đệ quy kiểm tra xem liệu việc thêm bước đi vừa rồi có dẫn đến lời giải không.
  B3.3: Nếu bước đi được thực hiện ở trên không dẫn đến lời giải. Xóa bỏ giá trị bước đi đó khỏi
   mảng kết quả, thử phương án tương ứng khác .
  B3.4: Nếu bước đi này dẫn đến lời giải, return true.
  B4: Nếu không có phương án tương ứng nào cho kết quả, return false.
   */
  private static final int N = 5;

  public static void main(String[] args) {
    int[][] sol = new int[N][N]; // mảng lưu các vị trí trên bàn cờ
    // khởi tạo giá trị mặc định cho mảng
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        sol[i][j] = -1;
      }
    }
//    // các cặp tọa độ mà quân mã có thể di chuyển từ vị trí hiện tại tính theo chụp Oxy
//    int[] xMove = {2, 1, -1, 2, -2, 1, -1, -2};
//    int[] yMove = {1, -2, 2, -1, -1, 2, -2, 1};
    int []xMove = { -2,-2,-1,-1, 1, 1, 2, 2};
    int []yMove = { -1, 1,-2, 2,-2, 2,-1, 1};
    // giả sử quân mã bắt đầu từ ô đầu tiên tọa độ (0, 0)
//    sol[0][0] = 0;
    // tìm lời giải:
    boolean isSolved = solveKnightTour(1, 1, 1, sol, xMove, yMove);
    if (!isSolved) {
      System.out.println("Không tìm được lời giải.");
    } else {
      showResult(sol);
    }
  }

  /**
   * Phương thức tìm lời giải cho bài toán. Tại vị trí (x, y) nếu đặt quân mã dẫn tới lời giải sẽ đánh dấu
   * vị trí đó với giá trị g là bước đi kế tiếp để tiến đến kết quả cuối cùng. Sau khi thực hiện mỗi bước
   * đi của quân mã sẽ được ghi lại trong ma trận chứa lời giải sau cùng.
   *
   * @param x        tọa độ x của ô đang xem xét đặt quân mã
   * @param y        tọa độ y của ô đang xem xét đặt quân mã
   * @param moveStep bước đi tiếp theo của quân mã
   * @param sol      ma trận kết quả
   * @param xMove    các tọa độ x mà quân mã có thể di chuyển tới từ vị trí hiện thời
   * @param yMove    các tọa độ y mà quân mã có thể di chuyển tới từ vị trí hiện thời
   * @return true nếu tìm được 1 lời giải và false nếu không tìm được lời giải
   */
  private static boolean solveKnightTour(int x, int y, int moveStep, int[][] sol, int[] xMove, int[] yMove) {
    int nextX;
    int nextY;
    if (moveStep == N * N) {
      return true;
    }
    for (int i = 0; i < N; i++) {
      nextX = x + xMove[i];
      nextY = y + yMove[i];
      if (isSafe(nextX, nextY, sol)) {
        sol[nextX][nextY] = moveStep;
        if (solveKnightTour(nextX, nextY, moveStep + 1, sol, xMove, yMove)) {
          return true;
        } else {
          sol[nextX][nextY] = -1; // quay lui
        }
      }
    }
    return false;
  }

  /**
   * Phương thức kiểm tra việc đặt quân mã ở vị trí x, y có thỏa mãn hay không
   *
   * @param x   tọa độ vị trí x tại đó cần đặt quân mã
   * @param y   tọa độ vị trí y tại đó cần đặt quân mã
   * @param sol ma trận lưu kết quả
   * @return true nếu quân mã có thể đặt được tại vị trí (x, y) trong ma trận sol
   */
  private static boolean isSafe(int x, int y, int[][] sol) {
    return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
  }

  /**
   * Phương thức hiển thị kết quả
   *
   * @param sol ma trận kết quả
   */
  private static void showResult(int[][] sol) {
    for (var row : sol) {
      for (var e : row) {
        System.out.printf("%3d", e);
      }
      System.out.println();
    }
  }
}
