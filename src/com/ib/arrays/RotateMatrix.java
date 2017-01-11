package com.ib.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by krishna.m1 on 06/05/16.
 */
public class RotateMatrix {

    public void rotate(ArrayList<ArrayList<Integer>> a) {

        final int N = a.size();

        for(int index = 0; index < N/2; index++) {

            int n = (N - (2 * index));
            for(int i = index; i < (n - 1 + index); i++) {

                int r = index;
                int c = i;
                int tmpR;

                int temp = a.get(r).get(c);
                while(true) {

                    int temp1 = a.get(c).get(n - 1 - r + (2 * index));
                    a.get(c).set(n - 1 - r + (2 * index), temp);
                    temp = temp1;

                    tmpR = r;
                    r = c;
                    c = (n - 1 - tmpR + (2 * index));
                    if(r == index && c == i)
                        break;
                }

            }

        }

    }

    public ArrayList<ArrayList<Integer>> rotateMatrix(ArrayList<ArrayList<Integer>> a) {

        if(a == null || a.size() == 1) {
            return a;
        }

        int N = a.size();
        int A[][] = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                A[j][N - 1 - i] = a.get(i).get(j);
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>(N);
        for(int i = 0; i < N; i++) {
            ArrayList<Integer> row = new ArrayList<>(N);
            for(int j = 0; j < N; j++) {
                row.add(A[i][j]);
            }
            result.add(row);
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> rotatematrix(ArrayList<ArrayList<Integer>> a) {

        int N = a.size();

        for(int layer = 0; layer < N/2; layer++) {

            int first = layer;
            int last = N - layer - 1;

            for(int i = first; i < last; i++) {

                int offset = last + first - i;

                int temp = a.get(layer).get(i);
                a.get(layer).set(i, a.get(offset).get(layer));
                a.get(offset).set(layer, a.get(last).get(offset));
                a.get(last).set(offset, a.get(i).get(last));
                a.get(i).set(last, temp);
            }
        }

        return a;
    }


    public static void main(String args[]) {

        RotateMatrix rotateMatrix = new RotateMatrix();

        ArrayList<ArrayList<Integer>> input = new ArrayList<>(5);
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);
        row1.add(4);
        row1.add(5);
        input.add(row1);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(6);
        row2.add(7);
        row2.add(8);
        row2.add(9);
        row2.add(10);
        input.add(row2);

        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(11);
        row3.add(12);
        row3.add(13);
        row3.add(14);
        row3.add(15);
        input.add(row3);

        ArrayList<Integer> row4 = new ArrayList<>();
        row4.add(16);
        row4.add(17);
        row4.add(18);
        row4.add(19);
        row4.add(20);
        input.add(row4);

        ArrayList<Integer> row5 = new ArrayList<>();
        row5.add(21);
        row5.add(22);
        row5.add(23);
        row5.add(24);
        row5.add(25);
        input.add(row5);


        for(int i = 0; i < input.size(); i++)
            System.out.println(input.get(i));

        rotateMatrix.rotatematrix(input);
        System.out.println();

        for(int i = 0; i < input.size(); i++)
            System.out.println(input.get(i));

    }
}
