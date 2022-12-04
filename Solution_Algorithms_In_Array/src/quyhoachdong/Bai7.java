package quyhoachdong;

import java.util.Scanner;

public class Bai7 {
  public static void main(String[] args) {
    System.out.print(" Nhap vao do dai cua chuoi con : ");
    int n = new Scanner(System.in).nextInt();

    int []array = new int[n];//mang chua gia tri
    int []length = new int[n];//mang chua do dai tang dan

    for (int i = 0 ; i < n ; i++)
      array[i] = new Scanner(System.in).nextInt();


    for (int i = 0 ; i < n ; i++){
      length[i] = 1;
    }
/*
    1 3 2 8 3 4 5
    1 2 2 3 3 3 4
    => 1 3 4 5
    => 1 2 4 5


     3 > 1 => L[1] = 1 + 1 = 2
     2 > 1 => L[2] = 1 + 1 = 2
     i = 3 <=> A[3] = 8
     8 > 1 => L[3] = 2;
     8 > 3 => L[3] = MAX(2 , 2+1) = 3;
     8 > 2 => L[3] = MAX(3 , 2 + 1) = 3
 */
//    {10, 22, 9, 30, 27, 45, 41, 62, 87}
//    {10, 22, 30, 45, 62, 87}.
    int maxSubLength = 1;
    for (int i = 1 ; i < n  ; i++){
      for (int j = 0 ; j < i ; j++){
        if(array[j] < array[i]){
          length[i] = Math.max(length[i] , length[j] + 1);
        }
      }
      maxSubLength = Math.max(maxSubLength , length[i]);
    }
    //Do dai mang con max
    System.out.println(maxSubLength);

    //Truy vet mang con
    int cnt = maxSubLength , k = 0;
    int arrSubChild[] = new int[100];

    for (int i = n-1 ; i >= 0 ;i--){
      if(length[i] == cnt){
        arrSubChild[k] = array[i];
        k++;  cnt--;
      }
    }
    for (int i = k-1 ; i >= 0 ; i--){
      System.out.print(arrSubChild[i] + " ");
    }

  }
}
