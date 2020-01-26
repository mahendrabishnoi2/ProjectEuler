 /*
https://www.hackerrank.com/contests/projecteuler/challenges/euler005/problem
Project Euler #7: 10001st prime
*/
import java.io.*;
import java.util.*;

public class Solution007 {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n < 4) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i*i <= n; i = i+6) {
            if (n % i == 0 || n%(i+2) == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            if (primes.size() >= n) {
                System.out.println(primes.get(n-1));
            } else {
                int prime_count = primes.size();
                int num;
                if (primes.size() == 0) num = 2;
                else num = primes.get(primes.size()-1) + 1;
                int res = -1;
                while (prime_count < n) {
                    if (isPrime(num)) {
                        primes.add(num);
                        prime_count++;
                        res = num;
                    }
                    num++;
                }
                System.out.println(res);
            }
        }
    }
}