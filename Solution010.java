/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler010/problem
Project Euler #10: Summation of primes
*/
import java.io.*;
import java.util.*;

public class Solution010 {

    public static void main(String[] args) {
        int[] nums = new int[999999];
        boolean[] flag = new boolean[999999];
        Arrays.fill(flag, true);

        for (int i = 0; i < 999999; i++) {
            nums[i] = i + 2;
        }
        // use sieve of eratosthenes to calculate prime numbers upto 1000000 (max input n)
        for (int i = 0; i < 999999; i++) {
            if (flag[i] == true) {
                int num = nums[i];
                for (int j = num+i; j < 999999; j=j+num) {
                    flag[j] = false;
                }
            }
        }
		
		// create another array to store sum of primes upto n
        long[] sum = new long[999999];
        sum[0] = 2l;
        for (int i = 1; i < 999999; i++) {
            if (flag[i] == true) {
                sum[i] = sum[i-1] + Long.valueOf(nums[i]); 
            }
            else {
                sum[i] = sum[i-1];
            }
        }
		
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            long res;
            if (n > 1) {
                res = sum[n-2];
            } else {
                res = 0l;
            }
            System.out.println(res);
        }
    }
}
