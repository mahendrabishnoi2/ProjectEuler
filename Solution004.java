 /*
https://www.hackerrank.com/contests/projecteuler/challenges/euler004/problem
Project Euler #4: Largest palindrome product
*/
import java.io.*;
import java.util.*;

public class Solution004 {
    public static boolean palindrome(int n) {
        String str = String.valueOf(n);
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int largest = -1;
            for (int i = 111; i <= 999; i++) {
                for (int j = 111; j <= 999; j++) {
                    int prod = i * j;
                    if (prod > 99999 && prod < n) {
                        boolean isPalindrome = palindrome(prod);
                        if (isPalindrome && prod > largest) {
                            largest = prod;
                        }
                    }
                }
            }
            System.out.println(largest);
        }
    }
}