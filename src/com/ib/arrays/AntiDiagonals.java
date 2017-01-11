package com.ib.arrays;

import java.util.ArrayList;

/**
 * Created by krishna.m1 on 15/12/16.
 */
public class AntiDiagonals {
    public ArrayList<Integer> getAntiDiagnoal(int row, int col, ArrayList<ArrayList<Integer>> a) {
        ArrayList<Integer> list = new ArrayList<>();
        int N = a.size();
        while (row < N && col >= 0) {
            list.add(a.get(row).get(col));
            row += 1;
            col -= 1;
        }

        return list;
    }
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        if (a == null) {
            return null;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int N = a.size();
        int i;

        for (i = 0; i < N; i++) {
            result.add(getAntiDiagnoal(0, i, a));
        }

        for (i = 1; i < N; i++) {
            result.add(getAntiDiagnoal(i, N - 1, a));
        }

        return result;
    }

    public static void main(String args[]) {
        AntiDiagonals antiDiagonals = new AntiDiagonals();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(4);

        arr.add(row1);
        arr.add(row2);

        System.out.println(antiDiagonals.diagonal(arr));
    }
}
