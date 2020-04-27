/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler012/problem
Project Euler #12: Highly divisible triangular number
*/
import java.util.Scanner;

public class Solution012 {
  private static int numberOfDivisors(int n) {
    int count = 0;
    int sqrt = (int) Math.sqrt(n);
    for (int i = 1; i <= sqrt; i++) {
      if (n % i == 0) {
        count += 2;
      }
    }
    if (sqrt * sqrt == n) {
      count--;
    }
    return count;
  }

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    int i = 1;
    int number = 0;
    while (t-- != 0) {
      int n = in.nextInt();
      while (numberOfDivisors(number) <= n) {
        number += i;
        i++;
      }
      System.out.println(number);
    }
  }
}


