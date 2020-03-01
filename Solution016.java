/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler016/problem
Project Euler #16: Power digit sum
*/
import java.math.BigInteger;
import java.util.Scanner;

public class Solution016 {

  public static int digitSum(String num) {
    int len = num.length();
    int sum = 0;
    for (int i = 0; i < len; i++) {
      sum += Character.getNumericValue(num.charAt(i));
    }
    return sum;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    BigInteger b = new BigInteger("2");
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      BigInteger res = b.pow(n);
      System.out.println(digitSum(res.toString()));
    }
  }
}