package com.ib.math;

import java.util.ArrayList;

/**
 * Created by krishna.m1 on 09/05/16.
 */
public class RearrangeArray {

    public void arrange(ArrayList<Integer> a) {

        int N = a.size();
        for(int i = 0; i < N; i++) {
            int pickFromIndex = a.get(i);
            a.set(i, a.get(i) + (a.get(pickFromIndex) % N) * N);
            System.out.println(a);
        }

        for(int i = 0; i < N; i++) {
            a.set(i, a.get(i) / N);
        }
    }

    public static void main(String args[]) {

        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(0);

        new RearrangeArray().arrange(input);
        System.out.println(input);
    }
}
