package dequy;

import java.util.Scanner;

public class Bai7 {

  public static void main(String[] args) {
    String s = new Scanner(System.in).nextLine();
    reverseString(s);
  }

  public static void reverseString(String s) {
    //abcd => dcba
    if (s.length() == 0) return;
    System.out.print(s.charAt(s.length() - 1));
    reverseString(s.substring(0, s.length() - 1));
  }
}
