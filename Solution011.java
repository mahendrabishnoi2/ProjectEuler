/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler011/problem
Project Euler #11: Largest product in a grid
*/
import java.io.*;
import java.util.*;

public class Solution011 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[23][26];
        for(int grid_i=0; grid_i < 20; grid_i++){
            for(int grid_j=3; grid_j < 23; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        int maxProduct = 0;
        int rightProd = 0;
        int downProd = 0;
        int diagPosProd = 0;
        int diagNegProd = 0;

        for (int i = 0; i < 20; i++) {
            for (int j = 3; j < 23; j++) {
                rightProd = grid[i][j] * grid[i][j+1] * grid[i][j+2] * grid[i][j+3];
                if (rightProd > maxProduct) {
                    maxProduct = rightProd;
                }
        
                downProd = grid[i][j] * grid[i+1][j] * grid[i+2][j] * grid[i+3][j];
                if (downProd > maxProduct) {
                    maxProduct = downProd;
                }
                diagPosProd = grid[i][j] * grid[i+1][j+1] * grid[i+2][j+2] * grid[i+3][j+3];
                if (diagPosProd > maxProduct) {
                    maxProduct = diagPosProd;
                }
        
                diagNegProd = grid[i][j] * grid[i+1][j-1] * grid[i+2][j-2] * grid[i+3][j-3];
                if (diagNegProd > maxProduct) {
                    maxProduct = diagNegProd;
                }
            }
        }

        System.out.println(maxProduct);
    }
}