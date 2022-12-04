package quaylui;

import java.util.Stack;

public class SubSet {
  int []numbers;
  int sum;

  Stack<Integer> solutionTest;
  boolean hasSolution;

  public SubSet(int[] numbers, int sum) {
    this.numbers = numbers;
    this.sum = sum;
    this.solutionTest = new Stack<>();
    this.hasSolution = false;
  }

  public void solve(int s , int index){
    //return false if s value exceed sum
    if (s > sum){
      return;
    }
    if (s == sum){
      hasSolution=true;
      displaySolutionTest();
      //Though found a solution but diliberately returning to find more 
      return;
    }
    for (int i = index ; i < numbers.length ; i++) {
      //Adding element to the stack
      solutionTest.push(numbers[i]);
      //add set[i] to the 's' and recusively start from next number
      solve(s+numbers[i],i+1);
      //Removing element from stack i.e Backtracking
      solutionTest.pop();
    }
  }

  private void displaySolutionTest() {
    for (Integer item: solutionTest){
      System.out.print(item+" ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int []set = {10, 7, 5, 18, 12, 20, 15};

    int size = 30;

    SubSet subSet = new SubSet(set , size);
    subSet.solve(0 , 0);

    if(!subSet.hasSolution){
      System.out.println("No solution!");
    }
  }
}
