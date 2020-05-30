/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler022/problem
Project Euler #22: Names scores
*/
import java.io.*;
import java.util.*;

public class Solution022 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    String[] s = new String[n]; 
    for (int i = 0; i < n; ++i) {
      s[i] = in.next();
    }
    Arrays.sort(s);
    HashMap<String, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length; ++i) {
      int score = 0;
      for (char c: s[i].toCharArray()) {
        score += ((int)c - 64);
      }
      score *= (i+1);
      map.put(s[i], score);
    }

    int q = in.nextInt();

    while (q-- > 0) {
      System.out.println(map.get(in.next()));
    }
  }
}
