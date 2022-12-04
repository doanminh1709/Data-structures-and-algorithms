package quyhoachdong;

public class Bai2 {
  private static int MAX = 20;
  private static final int [] result = new int[MAX];

  public static void main(String[] args) {
    System.out.println("Giai thua : " + giaithuaV1(4));
    System.out.println("\nGiai thua : " + giaiThua(4));
  }

  public static int giaithuaV1(int n){
    int i = 1;
    for (int j = 2 ; j <= n ; j++){
      i*=j;
    }
    return i;

  }

  public static int giaiThua(int n){
    if(n < 0){
      return 0;
    }else if (n == 0){
      return 1;
    }else{
      return n*giaiThua(n-1);
    }
  }
}
