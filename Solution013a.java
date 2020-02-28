/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler013/problem
Project Euler #13: Large sum
*/
import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution013a {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    
    BigInteger sum;
    sum = BigInteger.ZERO;

    for (int i = 0; i < t; i++) {
      sum = sum.add(in.nextBigInteger());
    }
    
    String sum_out = sum.toString();
    for (int i = 0; i < 10; i++) {
      System.out.print(sum_out.charAt(i));
    }
    System.out.println();
  }
}