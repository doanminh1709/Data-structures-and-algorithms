package quyhoachdong;

import java.util.Scanner;

public class TimSoDongXuItNhat {
  public static void main(String[] args) {


    System.out.print(" Nhap vao tong S : ");
    int S = new Scanner(System.in).nextInt();

    System.out.print(" Nhap so dong xu : ");
    int n = new Scanner(System.in).nextInt();

    int []value = new int[n];
    for (int i = 0 ; i < n ; i++)
      value[i] = new Scanner(System.in).nextInt();

    int []dp = new int[S+1];
    for (int i =  0 ; i <= S  ; i++ ){
      dp[i] = Integer.MAX_VALUE;
    }
    //Khoi tao
    dp[0] = 0;

    for (int i = 0 ; i <= S ; i++){
      for (int j = 0 ; j < n ; j++){
        if(value[j] <= i && dp[i-value[j]] + 1  < dp[i]){
          dp[i] = dp[i-value[j]] + 1;
        }
      }
    }
    System.out.println(dp[S]);
  }
}
