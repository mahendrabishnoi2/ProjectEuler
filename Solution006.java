 /*
https://www.hackerrank.com/contests/projecteuler/challenges/euler006/problem
Project Euler #6: Sum square difference
*/
import java.io.*;
import java.util.*;

public class Solution006 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            long sum_n = (n * (n+1)) / 2;
            long sum_n_sqr = sum_n * sum_n;

            long sqr_n_sum = (n * (n+1) * (2*n + 1)) / 6;
            System.out.println(sum_n_sqr - sqr_n_sum);
        }
    }
}