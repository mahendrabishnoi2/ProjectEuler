/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler013/problem
Project Euler #13: Large sum
*/
import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = Integer.parseInt(in.nextLine());
    int[][] nums = new int[t][50];
    String sum = "";
    for (int j = 0; j < t; j++) {
      String num_in = in.nextLine();
      for (int i = 0; i < 50; i++) {
        nums[j][i] = Character.getNumericValue(num_in.charAt(i));
      }
    }

    int carry = 0;
    int temp = 0;
    for (int i = 49; i >= 0; i--) {
      temp = carry;
      for (int j = 0; j < t; j++) {
        temp += nums[j][i];
      }
      sum = String.valueOf(temp % 10) + sum;
      carry = temp / 10;
    }

    sum = String.valueOf(carry) + sum;
    
    for (int i = 0; i < 10; i++) {
        System.out.print(sum.charAt(i));
    }
    System.out.println();
  }
}
