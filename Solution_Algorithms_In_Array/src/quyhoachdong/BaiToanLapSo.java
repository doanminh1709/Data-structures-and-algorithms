package quyhoachdong;

import java.util.Scanner;

public class BaiToanLapSo {
  private static final int MAX = 100;
  private static int []result = new int[MAX];

  public static void main(String[] args) {

    int n = new Scanner(System.in).nextInt();
    System.out.printf("Create N : %d is %d\n" , n , createN(n));
    System.out.printf("Create N : %d is %d" , n , createNV2(n));

  }
  //The way 1 : Top down
  public static int createN(int n){
    if(n < 0){
      return result[0] = 0;
    }else if (n==0){//Có một cách tạo số 0 là không lấy bất kì 1 thằng nào trong tập này
      return result[1] = 1;
    }else if(n > 0){
      result[n] = createN(n-1) + createN(n-3) + createN(n-5);
    }
    return result[n];
  }
  //The way 2 : Bottom up

  public static int createNV2(int n){
  //Vd : n = 4

    int result[] = new int[n+1];
    result[0] = 1;
    for (int i = 1 ; i <= n ; i++){
      result[i] = result[i] + result[i-1];
      if(i-3>=0){
        result[i] += result[i-3];
      }
      if(i - 5>=0){
        result[i] += result[i-5];
      }
    }
    return result[n];
  }

  //For 3 numbers { 1, 3 , 5} . How many way are there to make the
  //number n be 3 of these three numbers?

  //Create the number 6
  /*
  1 + 1 + 1 + 1 + 1 + 1
  1 + 5
  5 + 1
  3 + 3
  1 + 1 + 1 + 3
  1 + 1 + 3 + 1
  1 + 3 + 1 + 1
  3 + 1 + 1 + 1
   */
  //Create number n
//  state(n-1) , state(n-3) , state(n-5)
}
