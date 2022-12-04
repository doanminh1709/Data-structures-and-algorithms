package quaylui;

import java.util.Arrays;

public class TongTapCon {
  private static final int[] numbers = new int[]{1, 23, 3, 7, 25, 5, 29, 20};
  private static final int target = 30;
  private static boolean check = false;

  public static void main(String[] args) {

    if (!check) {
      generateSubnet();
    } else {
      System.out.println("No solution");
    }
  }

  private static void generateSubnet() {
    int[] subnets = new int[numbers.length];
    int total = 0;
    for (int number : numbers) {
      total += number;
    }
    if (total >= target) {
      solve(subnets, 0, 0, 0);
    }
  }

  private static void solve(int[] subnets, int subnetSize, int current, int sum) {

    Arrays.sort(numbers);
    if (sum == target) {
      check = true;
      showOutput(subnets, subnetSize);
    } else {
      if (current < numbers.length && sum + numbers[current] <= target) {
        // sinh các node dọc theo chiều rộng của mảng đầu vào
        for (int i = current; i < numbers.length; i++) {
          subnets[subnetSize] = numbers[i];
          if (sum + numbers[i] <= target) {
            solve(subnets, subnetSize + 1, i + 1, sum + numbers[i]);
          }
        }
      }
    }
  }

  private static void showOutput(int[] subnets, int subnetSize) {
    for (int i = 0; i < subnetSize; i++) {
      System.out.print(subnets[i] + " ");
    }
    System.out.println();
  }
}
