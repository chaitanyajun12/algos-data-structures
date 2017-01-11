package com.ib.math;

/**
 * Created by krishna.m1 on 14/05/16.
 */
public class UniquePaths {

    public int uniquePaths(int a, int b) {

        int[][] A = new int[a][b];
        int sum;

        for(int i = a - 1; i >= 0; i--) {

            for(int j = b - 1; j >= 0; j--) {

                if(i == (a - 1) && j == (b - 1)) {
                    A[i][j] = 1;
                } else {

                    sum = 0;
                    if((i + 1) < a)
                        sum += A[i + 1][j];

                    if((j + 1) < b)
                        sum += A[i][j + 1];

                    A[i][j] = sum;
                 }
            }

        }

        return A[0][0];
    }

    public static void main(String args[]) {
        System.out.println(new UniquePaths().uniquePaths(3, 2));
    }
}
