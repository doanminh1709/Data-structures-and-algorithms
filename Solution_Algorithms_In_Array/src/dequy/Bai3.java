package dequy;

public class Bai3 {
  public static void main(String[] args) {
    System.out.println(sumOfNumber(12345));
  }
  public static int sumOfNumber(int n){
    if (n < 10) return n;
    return n % 10 + sumOfNumber(n / 10);
  }
}
//Dau tien phai tach ra so cuoi

//123 % 10 + 12 % 10 + 1 = 3 + 2 + 1