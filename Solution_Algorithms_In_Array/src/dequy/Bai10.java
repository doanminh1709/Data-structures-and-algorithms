package dequy;

public class Bai10 {
  //Viết chương trình tính tổng S = 1 + 1/2 + 1/3 + ... + 1/n với n nguyên dương
  public static void main(String[] args) {
    System.out.println(sumOfFraction(3));
  }

  public static float sumOfFraction(int n) {
    if (n == 1) return n;
    return (float) 1 / n + sumOfFraction(n - 1);

  }
}

//1 + 1/2 + 1/3 = 3/2 + 1/3 = 9/6 + 2/6 = 11/6 = 2
