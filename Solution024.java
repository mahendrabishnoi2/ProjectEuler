/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler024/problem
Project Euler #24: Lexicographic permutations
*/
import java.io.*;
import java.util.*;

public class Solution024 {

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in = new Scanner(System.in);
    long[] fact = new long[15];
    fact[0] = 1;
    for (int i = 1; i < 14; i++) {
      fact[i] = i * fact[i-1];
    }
    
    int t = in.nextInt();
    while (t-- > 0) {
      long n = in.nextLong();
      char[] str = "abcdefghijklm".toCharArray();
      char[] ans = new char[str.length];

      int i = 0;  // track index to write in ans array
      int lettersRem = 13;
      while (i < 13) {
        long stepSize = fact[lettersRem - 1];
        // id will contains index of character to select for current index i
        // according to 1 indexing
        int id = (int)(n / stepSize);
        if (n % stepSize != 0) {
          id++;
          n = n % stepSize;
        } else {
          n = stepSize;
        }
        // fill char at index i in ans from index (id-1) in str
        ans[i] = str[id - 1];
        str[id - 1] = 'z';
        i++;
        lettersRem--;

        Arrays.sort(str);
      }
      System.out.println(new String(ans));
    }
  }
}
