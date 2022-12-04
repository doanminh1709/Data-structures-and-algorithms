package dequy;

public class Bai4 {
  public static void main(String[] args) {
    System.out.println(reverse(12345));
  }
  public static int reverse(int n) {
    if (n < 10) return n;
    System.out.print(n % 10);
    return reverse(n / 10);
  }
}