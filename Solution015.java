/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler015/problem
Project Euler #14: Lattice paths
*/
import java.util.Scanner;

public class Solution015 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long path[][] = new long[501][501];
    for (int i = 0; i < 501; i++) {
      path[i][0] = 1;
      path[0][i] = 1;
    }
    // precompute values
    for (int i = 1; i < 501; i++) {
      for (int j = 1; j < 501; j++) {
        path[i][j] = path[i - 1][j] + path[i][j - 1];
        if (path[i][j] > 1000000007) {
          path[i][j] = path[i][j] % 1000000007;
        }
      }
    }

    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int m = in.nextInt();
      System.out.println(path[n][m]);
    }
  }
}