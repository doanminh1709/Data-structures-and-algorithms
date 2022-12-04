package dequy;
//Tinh n giai thua
public class Bai1 {

  public static void main(String[] args) {
    System.out.println(giaiThua(5));
  }
  public static long giaiThua(int n){
    if (n == 0) return 1;
    return n * giaiThua(n - 1);
  }
}
