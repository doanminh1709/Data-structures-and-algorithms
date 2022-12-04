package quyhoachdong;

public class Bai5 {
  public static void main(String[] args) {
    int[] arr = new int[]{1, 11, 5, 8, 9, 2, 7, 4, 1, 8, 9};
//    jumpMin(arr);
    minJump(arr);
  }

  public static void jumpMin(int[] arr) {
    int n = arr.length;
    if (n == 0 || arr[0] == 0) {
      System.out.println("Khong the di duoc den dich ");
      return;
    }
    int max = arr[0], cnt = 1;
    int k = 0;
    int jum = max, m = k;
    for (int i = 0; i < n - 1; i++) {
      if (max+k > n){
        break;
      }else {
        cnt++;
      }
      for (int j = m; j <= jum + m; j++) {
        if (arr[j] > max) {
          max = arr[j];
          k = j;
        }
      }
      jum = max;
      m = k;
    }
    System.out.println(cnt);
  }

  public static void minJump(int arr[]){
    int []jump = new int[arr.length];
    jump[0] = 0;
    for (int i  = 1 ; i < arr.length ; i++){
      jump[i] = Integer.MAX_VALUE;
      //i luon nho hon j thi arr[j] phai luon khac max_Value
      for (int j = 0 ; j < i ; j++){
//        j < i =>
        //&& arr[j] != Integer.MAX_VALUE
        if(i <= j+arr[j] ){
          jump[i] = Math.min(jump[i] , jump[j] + 1);
          break;
        }
      }
    }
    for (int item : arr){
      System.out.print(item + " ");
    }
    System.out.println();
    for (int item : jump){
      System.out.print(item + " ");
    }
  }
}
