 /*
https://www.hackerrank.com/contests/projecteuler/challenges/euler005/problem
Project Euler #5: Smallest multiple
*/
import java.io.*;
import java.util.*;

public class Solution005 {
    public static int gcd(int a, int b) {
        if (b == 0) 
            return a;
        return gcd(b, a%b);
    }

    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b; // ab/gcd(a,b) or a/gcd(a,b) * b
    }

    public static int lcmN(int n) {
        int leastMultiple = 1;

        for (int i = 2; i <= n; i++) {
            leastMultiple = (leastMultiple > i ? lcm(leastMultiple, i) : lcm(i, leastMultiple));
        }

        return leastMultiple;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int leastMultiple = lcmN(n);
            System.out.println(leastMultiple);
        }
    }
}