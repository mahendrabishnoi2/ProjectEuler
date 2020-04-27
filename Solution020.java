/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler020/problem
Project Euler #20: Factorial digit sum
*/
import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution020 {
  static int getDigitSum(String n) {
    int sum = 0;
    for (int i = 0; i < n.length(); i++) {
      sum += Character.getNumericValue(n.charAt(i));
    }
    return sum;
  }

  public static void main(String[] args) {
    BigInteger[] fact = new BigInteger[1001];
    fact[0] = new BigInteger("1");
    for (int i = 1; i < 1001; i++) {
      fact[i] = fact[i-1].multiply(new BigInteger(String.valueOf(i)));
    }

    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      System.out.println(getDigitSum(fact[n].toString()));
    }
  }
    
}
