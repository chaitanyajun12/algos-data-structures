package com.ib.binarysearch;

import java.util.ArrayList;

/**
 * Created by krishna.m1 on 15/05/16.
 */
public class MatrixSearch {

    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {

        int colStart = 0;
        int colEnd = a.get(0).size() - 1;
        int row = 0;
        int mid;

        while (true) {

            if(colStart > colEnd) {

                row += 1;
                if(row >= a.size())
                    break;
                colStart = 0;
                colEnd = a.get(0).size() - 1;

            } else {

                mid = (colStart + colEnd) / 2;

                if (a.get(row).get(mid) == b) {
                    return 1;
                } else if(a.get(row).get(mid) < b) {
                    colStart = mid + 1;
                } else {
                    colEnd = mid - 1;
                }
            }
        }

        return 0;
    }

    public static void main(String args[]) {

        ArrayList<ArrayList<Integer>> input = new ArrayList<>();

        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(3);
        row1.add(5);
        row1.add(7);

        input.add(row1);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(10);
        row2.add(11);
        row2.add(16);
        row2.add(20);

        input.add(row2);

        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(23);
        row3.add(30);
        row3.add(34);
        row3.add(50);

        input.add(row3);

        System.out.println(new MatrixSearch().searchMatrix(input, 100));

    }
}
