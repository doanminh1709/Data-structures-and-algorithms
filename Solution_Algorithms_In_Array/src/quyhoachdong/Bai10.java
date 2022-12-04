package quyhoachdong;

public class Bai10 {
  private static long [] result = new long[100000];
  public static void main(String[] args) {
    System.out.println(transfer(50));
  }

  public static long transfer(long n){
    if(n == 0){
      return 0;
    }else if(n < 12){
      return n;
    }else{
      if (n < 100000){
        if(result[(int)n] > 0) return result[(int) n];
      }
      long temp = Math.max(n , transfer(n/2) + transfer(n/3) + transfer(n/4));
      if(n < 100000){
        result[(int)n] = temp;
      }
      return temp;
    }

  }
}
