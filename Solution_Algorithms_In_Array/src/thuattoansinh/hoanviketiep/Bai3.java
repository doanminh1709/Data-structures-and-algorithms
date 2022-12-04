package thuattoansinh.hoanviketiep;

import java.util.Scanner;

public class Bai3 {

  public static boolean nextGenerate(String[] strings) {
    int i = strings.length - 2;
    while (i >= 0 && strings[i].compareTo(strings[i + 1]) > 0) {
      i--;
    }
    if (i >= 0) {
      int k = strings.length - 1;
      while (strings[i].compareTo(strings[k]) > 0) {
        k--;
      }
      String item = strings[i];
      strings[i] = strings[k];
      strings[k] = item;

      int r = i + 1;
      int d = strings.length - 1;
      while (r < d) {
        item = strings[r];
        strings[r] = strings[d];
        strings[d] = item;
        r++;
        d--;
      }
      return false;
    } else {
      return true;
    }
  }

  public static void generate(String[] strings) {
    boolean isMark = false;
    while (!isMark) {
      output(strings);
      isMark = nextGenerate(strings);
    }
  }

  public static void output(String[] strings) {
    for (String string : strings) {
      System.out.print(string + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    while (t > 0) {
      String s = sc.nextLine();
      String[] str = s.trim().split(" ");
      generate(str);
      t--;
    }

  }
}
