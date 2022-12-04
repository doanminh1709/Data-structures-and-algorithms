package dequy;

public class Bai8 {
  public static void main(String[] args) {
    System.out.println(ucln(10, 5));
  }
  public static int ucln(int a, int b) {
//    if (a == 0) return b;
//    return ucln(b % a , a);
    if (b == 0) return a;
    return ucln(b, a % b);

    // (8 % 6 , 6)
    // (6%2 , 2)
    // (0 , 2)
    // => ucln = b = 2

    //vd : a = 4 , b = 6
    /*
    ulcn (6 , 4 % 6) = (6 , 4) <=> a = 6 , b = 4
    ulcn(4 , 6%4) = (4 , 2) => a = 4 , b = 2
    ucln(2 , 4%2) = (2 , 0) dk b == 0 => return a

     */

    /*
    Th b < a
    a = b % a vd 5%10 = 5
    b = a = 10 //Doi cho a va b
     */
  }
}
