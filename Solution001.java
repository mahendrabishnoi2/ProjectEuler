import java.io.*;
import java.util.*;

public class Solution_001 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();

            int n_3 = (n - 1) / 3;	// find number of terms
            int n_5 = (n - 1) / 5;
            int n_15 = (n - 1) / 15;

            long l_3 = 3 + (n_3 - 1) * 3;	// find last term
            long l_5 = 5 + (n_5 - 1) * 5;
            long l_15 = 15 + (n_15 - 1) * 15;

            long sum_3 = (n_3 * (3 + l_3)) >> 1;	// find sum of AP
            long sum_5 = (n_5 * (5 + l_5)) >> 1;
            long sum_15 = (n_15 * (15 + l_15)) >> 1;

            long total = sum_3 + sum_5 - sum_15;
            System.out.println(total);
        }
    }
}

