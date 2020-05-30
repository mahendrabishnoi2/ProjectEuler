/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler023/problem
Project Euler #23: Non-abundant sums
https://en.wikipedia.org/wiki/Divisor_function
https://en.wikipedia.org/wiki/Abundant_number  // we can simply output YES if n > 20161
// I didn't use that property since my solution got accepted
*/
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution023 {

  static int[] spf = new int[100001];
  static boolean[] isPrime = new boolean[100001];
  static long[] d = new long[100001];
  static HashSet<Integer> abundantNumbers = new HashSet<>();

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

  static void findAbundantNumbers() {
    for (int i = 2; i <= 100000; ++i) {
      if (d[i] > i) abundantNumbers.add(i);
    }
  }

  public static void main(String[] args) {
    sieve();
    generateSum();
    findAbundantNumbers();
    // Collections.sort(abundantNumbers);

    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    while (t-- > 0) {
      int n = in.nextInt();
      
      boolean ok = false;
      for (int i: abundantNumbers) {
        if (i * 2 == n) {
          ok = true;
          break;
        } else if (abundantNumbers.contains(n - i)) {
          ok = true;
          break;
        }
      }
      System.out.println(ok ? "YES" : "NO");
    }
  }
}