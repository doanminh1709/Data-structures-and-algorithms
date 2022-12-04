package quyhoachdong;

import java.util.Scanner;

public class Bai8 {
  /*
  Bài toán tổng tập con. Cho một tập các phần tử C chứa các số nguyên không âm và một giá
  trị tổng S. Xác định xem liệu có tồn tại tập con nào của C có tổng bằng S không. In ra YES nếu có,
  NO nếu không tìm được.
  Ví dụ C = {3, 30, 12, 1, 5, 20}, S = 9. Kết quả YES. Vì tập con {3, 1, 5} có tổng là 9. Cũng với tập trên
  với S = 10, kết quả là NO vì không có tập con nào cho tổng bằng 10.
   */
  public static void main(String[] args) {
    //Tong
    System.out.print(" Nhap tong : ");
    int S = new Scanner(System.in).nextInt();

//    System.out.println(" Nhap n phan tu : ");
//    int n = new Scanner(System.in).nextInt();
//    int[] arr = new int[n];
//    for (int i = 0; i < n; i++)
//      arr[i] = new Scanner(System.in).nextInt();
//
//    int []result = new int[n+1];

    int n = 5 , a ;
    int[] dp = new int[100];
    for (int i = 0 ; i < 100 ; i++)
      dp[i] = 0;

    //Sử dụng phương pháp quy hoạch đông mảng đánh dấu
//    a = 1
//    j - a = 1 => j = 1
    dp[0] = 1;
    for(int i = 1 ; i <= n ; i++){
      a = new Scanner(System.in).nextInt();
      dp[a] = i;
      for (int j = S ; j >= a ; j--){
        if(dp[j-a] == 1) dp[j] = 1;
      }
    }

    if(dp[S] == 1) System.out.println("YES");
    else System.out.println("NO");

    for (int i = 0 ; i < 100 ; i++)
      System.out.print(dp[i] +  " ");

    //Test 1
//    S = 9 , C = {3, 30, 12, 1, 5, 20}  ==>YES
//    S = 10 , C = {3, 30, 12, 1, 5, 20} ==>NO

    //Tính ra số trường hợp mà từ các số trên có thể tạo thành tổng S , nếu có thể tính được thì in YES

    //Có mấy cách để tạo ra số n từ n số đã cho

  }
}
