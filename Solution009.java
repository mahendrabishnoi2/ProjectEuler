 /*
https://www.hackerrank.com/contests/projecteuler/challenges/euler009/problem
Project Euler #9: Special Pythagorean triplet
*/
import java.io.*;
import java.util.*;

public class Solution009 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int prod, res = -1;
            int n_half = n / 2 + 1; // i+j should not be less than n_half
            for (int i = 1; i < n-2; i++) {
                for (int j = n_half-i; j < n-1; j++) {
                    int k = n - i - j;
                    if (i*i + j*j > k*k) break;
                    else if (i*i + j* j == k*k) {
                        prod = i*j*k;
                        if (prod > res) {
                            res = prod;
                        }
                    } 
                }
            }
            System.out.println(res);
        }
    }
}