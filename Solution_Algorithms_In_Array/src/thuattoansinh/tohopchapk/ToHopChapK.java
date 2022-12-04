package thuattoansinh.tohopchapk;

public class ToHopChapK {
  public static boolean nextGenerate(int[] arr, int n) {
    int i = arr.length - 1;//Xuất phát từ phần tử cuối cùng của tổ hợp
    int k = arr.length;//lấy ra số phần tử của mảng
    while (i >= 0 && arr[i] == n - k + i + 1) {
      i--;//Giam i
    }
    if (i >= 0) {
      arr[i] = arr[i] + 1;
      for (int j = i + 1; j < k; j++) {
        arr[j] = arr[i] + j - i;//Gan arr[j] = arr[j] + j - i
      }
      return false;
    } else {
      return true;
    }
  }

  public static void generate(int[] arr, int n) {
    boolean isMark = false;
    while (!isMark) {
      output(arr);
      isMark = nextGenerate(arr, n);
    }
  }

  public static void output(int[] arr) {
    for (int item : arr) {
      System.out.print(item + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int n = 5, k = 3;
    int[] arr = new int[3];
    for (int i = 0; i < k; i++)
      arr[i] = i + 1;

    generate(arr, n);

  }
}
