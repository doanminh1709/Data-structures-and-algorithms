package dequy;
//Tim so fibonacci thu n
public class Bai2 {
  public static void main(String[] args) {
    System.out.println(fibonacci(6));
  }
  public static long fibonacci(int n){
    if (n == 0 || n == 1) return 1;
    return fibonacci(n - 2) + fibonacci(n - 1);
  }
}
