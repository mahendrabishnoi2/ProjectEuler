/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler018/problem
Project Euler #18: Maximum path sum I
*/
import java.util.Scanner;

public class Solution018 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int[][] nums = new int[n][n];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < i + 1; j++) {
          nums[i][j] = in.nextInt();
        }
      }

      int[][] dp = new int[n][n];
      dp[0][0] = nums[0][0];

      // recurrence : dp[i][j] = a[i][j] + max(dp[i-1][j-1], dp[i-1][j])
      // handle case when j-1 < 0 (when we are at index 0 of any row)
      // our output will be maximum element in dp[n-1] row
      for (int i = 1; i < n; i++) {
        for (int j = 0; j < i + 1; j++) {
          int idx = j - 1 < 0 ? 0 : j - 1;
          int a = (dp[i - 1][idx] < 0) ? 0 : dp[i - 1][idx];
          int b = dp[i - 1][j];
          int max = (a > b) ? a : b;
          dp[i][j] = nums[i][j] + max;
        }
      }

      int sum = 0;
      for (int i = 0; i < n; i++) {
        if (dp[n - 1][i] > sum) {
          sum = dp[n - 1][i];
        }
      }
      System.out.println(sum);
    }
  }
}