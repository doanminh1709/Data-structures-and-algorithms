package quyhoachdong;

import java.util.Scanner;

public class SpiralMatrix {
  public static void main(String[] args) {
    int n = new Scanner(System.in).nextInt();
    int[][] arr = new int[n][n];
    int len = n , k = 1 , p = 0;

    while(k <= n*n){

      //first row matrix
      for(int i = p ; i < len ; i++){
        arr[p][i] = k++;
      }

      //last column matrix
      for (int i = p+1 ; i < len ; i++){
        arr[i][len-1] = k++;
      }

      //last row matrix
      for(int i = len - 2 ; i >= p ; i--){
        arr[len-1][i] = k++;
      }

      //first col matrix
      for (int i = len - 2 ; i > p ; i--){
        arr[i][p] = k++;
      }
      p++; len--;
    }

    for (int i = 0 ; i < n ; i++){
      for (int j = 0 ; j < n ; j++){
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }

  }
}
