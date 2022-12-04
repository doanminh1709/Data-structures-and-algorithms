package thuattoansinh.hoanviketiep;

public class SinhHoanViKeTiep {

  static int[] arr = new int[]{1, 3, 2, -1};

  static void generate() {
    boolean isCheck = false;
    while (!isCheck) {
      output();
      isCheck = nextGenerate();
    }
  }

  private static void output() {
    for (var e : arr) {
      System.out.printf("%5d",e);
    }
    System.out.println();
  }

  static boolean nextGenerate() {
    //Kiểm tra lấy ra vị trí i mà arr[i] > arr[i+1]
    int i = arr.length - 2;
    while (i >= 0 && arr[i] > arr[i + 1]) {
      i--;
    }
    if (i >= 0) {
      int k = arr.length - 1;
      while (arr[i] > arr[k]) {
        k--;
      }
      int temp = arr[i];
      arr[i] = arr[k];
      arr[k] = temp;

      int r = i + 1;
      int s = arr.length - 1;
      while (r < s) {
        int tm = arr[r];
        arr[r] = arr[s];
        arr[s] = tm;
        r++;
        s--;
      }
      return false;
    } else {
      return true;
    }
  }
  public static void main(String[] args) {
      generate();
  }
}
