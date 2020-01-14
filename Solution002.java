/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler002/problem
Project Euler #2: Even Fibonacci numbers
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        // create an array which already stores fibonacci numbers
        // so that we don't have to computer again and again
        long[] fib = new long[1000];
        fib[0] = 1l;
        fib[1] = 2l;
        int i;
        for (i = 2; fib[i-1]+fib[i-2] <= 4e16; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long even_sum;
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            even_sum = 0;
            for (int j = 0; j < i && fib[j] <= n; j++) {
                if (fib[j] % 2 == 0) {
                    even_sum += fib[j];
                }
            }
            System.out.println(even_sum);
        }
    }
}

