package dequy;

public class Bai6 {
//tim chu so dau tien cua so nguyen duong n
public static void main(String[] args) {
  System.out.println(findByFirstNb(412345));
}
  public static int findByFirstNb(int n){
    if (n < 10) return n;
    return findByFirstNb(n / 10);
  }
}
