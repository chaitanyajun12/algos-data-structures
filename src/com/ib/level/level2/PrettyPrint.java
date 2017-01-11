package com.ib.level.level2;

import java.util.ArrayList;

/**
 * Created by krishna.m1 on 14/05/16.
 */
public class PrettyPrint {

    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {

        int N = (2 * a) - 1;
        int arr[][] = new int[N][N];
        int dir = 1;

        int L = 0, R = N - 1;
        int T = 0, B = N - 1;

        while(L <= R && T <= B) {

            if(dir == 1) {

                for(int i = L; i <= R; i++) {
                    arr[T][i] = a;
                }
                T++;
                dir = 2;
            } else if(dir == 2) {

                for(int i = T; i <= B; i++) {
                    arr[i][R] = a;
                }
                R--;
                dir = 3;
            } else if(dir == 3) {

                for(int i = R; i >= L; i--) {
                    arr[B][i] = a;
                }
                B--;
                dir = 4;
            } else if (dir == 4) {

                for(int i = B; i >= T; i--) {
                    arr[i][L] = a;
                }
                L++;
                dir = 1;
                a--;
            }

        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                row.add(arr[i][j]);
            }
            result.add(row);
        }

        return result;
    }

    public static void main(String args[]) {

        ArrayList<ArrayList<Integer>> result = new PrettyPrint().prettyPrint(3);
        for (ArrayList<Integer> row : result) {
            System.out.println(row);
        }

    }
}
