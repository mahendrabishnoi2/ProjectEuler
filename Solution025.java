/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler025/problem
Project Euler #25: N-digit Fibonacci number
*/
import java.io.*;
import java.util.*;

public class Solution025 {

  // this function will return number of digits in nth fibonacci number  
  // this function uses benet's formula to calculate number of digits
  // Math.log10(phi) = 0.20898764024997876
  // phi = golden ratio = (1 + Math.sqrt(5)) / 2
  // 1 / 2 * (Math.log10(5)) = 0.34948500216800943
  public static int numDigits(int n) {
    double d = n * 0.20898764024997876 - 0.34948500216800943;
    return (int)Math.ceil(d);
  }

  public static void main(String[] args) throws IOException {
    // numDigitIndex will hold the index of first fibonacci number whose 
    // count of digits is i (where i is index of array)
    int[] numDigitIndex = new int[5001];
    
    int i = 1;
    int j = 1;
    while (i < 5001) {
      int digits = numDigits(j);
      if (digits == i) {
        numDigitIndex[i] = j;
        i++;
      }
      j++;
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      System.out.println(numDigitIndex[n]);
    }
  }
}