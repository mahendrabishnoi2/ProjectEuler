/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler014/problem
Project Euler #14: Longest Collatz sequence
*/
import java.util.Scanner;

public class Solution014 {
  // Function to recursively calculate number of terms in collatz sequence.
  // Eg. for 3 collatz sequence is : 3->10->5->16->8->4->2->1
  // if we call this function with n = 3 then it will return number of terms in collatz sequence for
  // n = 3 and also fill values in array(dp) for no. of terms in collatz sequence for all numbers
  // which appear in collatz sequence of 3
  public static int countTerms(long n, int[] dp) {
    if (n % 2 == 0l) {
      n = n / 2;
    } else {
      n = 3l * n + 1l;
    }
    if (n > 5000000) {
      return 1 + countTerms(n, dp);
    } else {
      if (dp[(int) n] == 0) {
        dp[(int) n] = 1 + countTerms(n, dp);
      }
    }
    return dp[(int) n];
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] dp = new int[5000001];
    int[] dp_idx = new int[5000001];
	// Calculate the number of terms in collatz sequence for numbers 1 through 5000000
    dp[1] = 1;
    for (int i = 2; i < 5000001; i++) {
      if (dp[i] == 0) {
        dp[i] = 1 + countTerms((long) i, dp);
      }
    }
	
	// Calculate the number which has maximum number of terms in collatz sequence for numbers 1
    // through 5000000
    int max_idx = 1;
    for (int i = 1; i < 5000001; i++) {
      if (dp[i] >= dp[max_idx]) {
        dp_idx[i] = i;
        max_idx = i;
      } else {
        dp_idx[i] = max_idx;
      }
    }
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      System.out.println(dp_idx[n]);
    }
  }
}