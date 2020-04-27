/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler021/problem
Project Euler #21: Amicable numbers
https://en.wikipedia.org/wiki/Divisor_function
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution021 {

  static int[] spf = new int[100001];
  static boolean[] isPrime = new boolean[100001];
  static long[] d = new long[100001];
  static ArrayList<Integer> amicableNums = new ArrayList<>();

  static void sieve() {
    spf[1] = 1;
    Arrays.fill(isPrime, true);
    for (int i = 2; i <= 100000; ++i) {
      if (isPrime[i]) {
        spf[i] = i;

        if ((long) i * (long) i <= Integer.MAX_VALUE) {
          for (int j = i * i; j <= 100000; j += i) {
            spf[j] = i;
            isPrime[j] = false;
          }
        }
      }
    }
  }

  static HashMap<Integer, Integer> pFactors(int n) {
    HashMap<Integer, Integer> map = new HashMap<>();
    if (n < 2 || isPrime[n]) return map;

    while (n != 1) {
      int pf = spf[n];
      if (pf == 0) System.out.println(n);
      if (map.containsKey(pf)) {
        map.replace(pf, map.get(pf) + 1);
      } else map.put(pf, 1);
      n = n / pf;
    }
    return map;
  }

  static void generateSum() {
    d[1] = 1;
    for (int i = 2; i <= 100000; ++i) {
      if (isPrime[i]) d[i] = 1;
      else {
        HashMap<Integer, Integer> map = pFactors(i);
        long prod = 1;
        for (Entry<Integer, Integer> e : map.entrySet()) {
          long pf = (long) e.getKey();
          long power = (long) e.getValue();

          prod *= ((Math.pow(pf, power + 1) - 1) / (pf - 1));
        }
        prod -= i;
        d[i] = prod;
      }
    }
  }

  static void findAmicableNumbers() {
    for (long i = 2; i <= 100000; ++i) {
      long b = d[(int) i];
      if (b != i && b <= 100000) {
        if (d[(int) b] == i) amicableNums.add((int) i);
      }
    }
  }

  public static void main(String[] args) {
    sieve();
    generateSum();
    findAmicableNumbers();
    Collections.sort(amicableNums);

    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    while (t-- > 0) {
      int n = in.nextInt();
      int sum = 0;
      for (int i: amicableNums) {
        if (i >= n) {
          break;
        }
        sum += i;
      }
      System.out.println(sum);
    }
  }
}
