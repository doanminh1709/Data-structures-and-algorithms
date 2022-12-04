package dequy;

public class Bai9 {
  public static void main(String[] args) {
    System.out.println(sum(5));
  }
  public static long sum(int n){
    if (n == 1) return n;
    return n + sum(n - 1);
  }
}
// 1 + 2 + 3 + 4 + 5 = 15
