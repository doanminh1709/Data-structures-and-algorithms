package dequy;

public class Bai5 {
  //Dem ra so chu so cua so nguyen duong n

  public static void main(String[] args) {
    System.out.println(countOfNumber(123));
  }
  public static int countOfNumber(int n){
    int cnt = 1;
    if (n < 10 ) return 1;
    return cnt + countOfNumber(n / 10);

  }
}
//123/10 = 12
