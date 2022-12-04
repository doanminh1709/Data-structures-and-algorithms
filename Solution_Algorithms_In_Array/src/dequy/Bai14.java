package dequy;

public class Bai14 {

  public static void main(String[] args) {
    move(3 , 'A' , 'B' , 'C');
  }
  public static void move(int n , char source , char middle, char target){

    //Dau tien ta se chuyen n - 1 dia tu A sang B
    if (n == 0) return;
    move(n - 1 , source , target , middle);//Dau tien ta se chuyen n - 1 dia sang B lay C lam tg
    System.out.println("Step "+ n + " : From " + source + " to " + target);
    move(n - 1 , middle , source , target);//Sau se chuyen n - 1 dia tu B - C vs A la tg
  }
}
