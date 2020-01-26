 /*
https://www.hackerrank.com/contests/projecteuler/challenges/euler008/problem
Project Euler #8: Largest product in a series
*/
import java.io.*;
import java.util.*;

public class Solution008 {
    public static int productOfDigits(int n) {
        int product = 1;
        while(n > 0) {
            product = n % 10 * product;
            n = n / 10;
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            String num = in.next();
            int res = -1;
            for (int i = 0; i < (n-k+1); i++) {
                int endIndex = i + k;
                int number = Integer.parseInt(num.substring(i, endIndex));
                int product = productOfDigits(number);
                if (product > res) {
                    res = product;
                }
            }
            System.out.println(res);
        }
    }
}

