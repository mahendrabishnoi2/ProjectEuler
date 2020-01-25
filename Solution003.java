 /*
https://www.hackerrank.com/contests/projecteuler/challenges/euler003/problem
Project Euler #3: Largest prime factor
*/
import java.io.*;
import java.util.*;
import java.math.*;

public class Solution003 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();

            long maxPrime = -1l;

            while(n%2 == 0) {
                maxPrime = 2;
                n = n >> 1;
            }

            for (int i = 3; i <= Math.sqrt(n); i+= 2) {
                while(n%i==0) {
                    maxPrime = i;
                    n = n / i;
                }
            }

            if (n > 2) {
                maxPrime = n;
            }

            System.out.println(maxPrime);
        }
    }
}