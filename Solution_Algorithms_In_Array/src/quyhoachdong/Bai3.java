package quyhoachdong;

public class Bai3 {
  public static void main(String[] args) {
    //N mặt hàng có trọng lượng và giá tiền khác nhau
    //túi thì có trọng lượng tối đa là M
    //Nên bỏ những món đồ nào vào để để có thể thu được lợi nhuận tối đa
    // Lấy ra trường hợp mà có val max nhất từ các cặp trường hợp cộng lại từ cân nặng

    //Vd :  6 mặt hàng có giá trị lần lượt là
    int val[] = new int[]{60, 100, 120, 200};
    int weight[] = new int[]{10, 20, 30, 25};
    int n = val.length;
    int W = 50; // result : 60 100 200
    knapSack(W , weight, val , n);
  }

  // trả về giá trị lớn nhất có thể bỏ vào túi giới hạn khối lượng W
  // chiến lược bottom-up
  static void knapSack(int W, int[] weight, int[] value, int n) {
    int[][] result = new int[n + 1][W + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= W; j++) {
        if (i == 0 || j == 0) {
          result[i][j] = 0;
        } else if (weight[i - 1] <= j) {
          result[i][j] = Math.max(value[i - 1] + result[i - 1][j - weight[i - 1]], result[i - 1][j]);
        } else {
          result[i][j] = result[i - 1][j];
        }
      }
    }
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= W; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
      }
//    return result[n][W]; // trả về kết quả
  }
}

