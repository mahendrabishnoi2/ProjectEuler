/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler019/problem
Project Euler #19: Counting Sundays
https://en.wikipedia.org/wiki/Zeller%27s_congruence
*/
import java.util.Scanner;

public class Solution019 {

  // this function uses zeller's congruence algorithm to provide day of the week for any month given
  // day of month, month, year
  public static long zellerCongruence(long day, long month, long year) {
    if (month < 3) {
      month += 12;
      year -= 1l;
    }
    long q = day;
    long m = month;
    long k = year % 100l;
    long j = year / 100;
    long h = q + (13 * (m + 1) / 5) + k + j / 4 + k / 4 + 5 * j;
    h = h % 7;
    return h;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    while (t-- > 0) {
      boolean flag = true;
      long start_y = in.nextLong();
      long start_m = in.nextLong();
      long start_d = in.nextLong();
      long end_y = in.nextLong();
      long end_m = in.nextLong();
      long end_d = in.nextLong();

      long count = 0;

      start_m = start_m + ((start_d == 1) ? 0 : 1);
      for (long year = start_y; year <= end_y; year++) {
        for (long month = 1; month < 13; month++) {
          if (year == start_y && month < start_m) ;
          else if (year == end_y && month > end_m) ;
          else {
            long h = zellerCongruence(1, month, year);
            if (h == 1) {
              count++;
            }
          }
        }
      }

      System.out.println(count);
    }
  }
}