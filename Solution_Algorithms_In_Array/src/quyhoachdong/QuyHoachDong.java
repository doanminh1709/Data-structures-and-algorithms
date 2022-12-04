package quyhoachdong;

import java.util.Scanner;

public class QuyHoachDong {
  private static final int MAX = 90;
  private static long []fibo = new long[MAX];

  public static void main(String[] args) {
    int n = new Scanner(System.in).nextInt();
    System.out.printf("Top-down: F%d = %d\n", n, fibonacci(n));
    System.out.printf("Bottom-up: F%d = %d\n", n, fibonacciV2(n));
  }
  //có 2 hướng tiếp cận top down và bottom up
  //C1: top down : chia nhỏ bài toán từ to thành nhỏ

  //C2: bottom up : làm bài toán nhỏ xong đến bài toán to
  //Ví dụ : Sử lý bài toán tính số fibonacci sử dụng quy hoặc động
  //C1 : top - down
  public static long fibonacci(int n){
    if (n < 2){
      return fibo[n] = n;
    }
    if (fibo[n] == 0){
      fibo[n] = fibonacci(n-1) + fibonacci(n-2);
    }
    return fibo[n];
  }

  //C2 : Botom up
  public static long fibonacciV2(int n){
      long f0=0 , f1=1 , fn=0;
      for (int i = 2 ; i<= n ; i++){
        fn = f0+f1;
        f0 = f1;
        f1 = fn;
      }
      return fn;
  }
}
