/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler017/problem
Project Euler #17: Number to Words
*/
import java.util.Scanner;

public class Solution017 {
  static String processThreeDigits(int num) {
    String[] s1 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] s2 = {
      "Ten",
      "Eleven",
      "Twelve",
      "Thirteen",
      "Fourteen",
      "Fifteen",
      "Sixteen",
      "Seventeen",
      "Eighteen",
      "Nineteen"
    };
    String[] s3 = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String res = "";
    if (num > 99) {
      int third = num / 100;
      res += s1[third] + " Hundred ";
      num = num % 100;
    }
    if (num > 19) {
      int first = num % 10;
      int second = (num / 10) % 10;
      res += s3[second - 2] + " " + s1[first];
    } else if (num > 9) {
      int first = num % 10;
      res += s2[first];
    } else {
      res += s1[num];
    }

    if (res.length() != 0 && res.substring(res.length() - 1).equals(" ")) {
      res = res.substring(0, res.length() - 1);
    }
    return res;
  }

  static String numToText(String num) {
    int len = num.length();

    String[] s4 = {"", "Thousand", "Million", "Billion"};

    if (num == "0") {
      return "Zero";
    }
    int temp;
    if (len % 3 == 0) {
      temp = len / 3;
    } else {
      temp = len / 3 + 1;
    }
    String res = "";
    int start = 0;
    int end = (len % 3 == 0) ? (start + 3) : (start + len % 3);
    for (int i = 0; i < temp; i++) {
      int n = Integer.parseInt(num.substring(start, end));
      if (n != 0) {
        res += processThreeDigits(n) + " " + s4[temp - i - 1] + " ";
      }
      start = end;
      end = start + 3;
    }
    while (res.substring(res.length() - 1).equals(" ")) {
      res = res.substring(0, res.length() - 1);
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      String num = in.next();
      System.out.println(numToText(num));
    }
  }
}
