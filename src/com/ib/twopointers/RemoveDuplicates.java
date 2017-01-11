package com.ib.twopointers;

import java.util.ArrayList;

/**
 * Created by krishna.m1 on 18/12/16.
 */
public class RemoveDuplicates {

    public int removeDuplicatesII(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) {
            return 0;
        }

        int ptrIndex = 0;
        int k = 1;
        int N = a.size();

        for (int i = 1; i < N; i++) {
            if (a.get(i).equals(a.get(ptrIndex))) {
                if (k < 2) {
                    ptrIndex += 1;
                    k += 1;
                    a.set(ptrIndex, a.get(i));
                }
            } else {
                k = 1;
                ptrIndex += 1;
                a.set(ptrIndex, a.get(i));
            }
        }

        return ptrIndex + 1;
    }


    public int removeDuplicates(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) {
            return 0;
        }

        int ptrIndex = 0;
        int N = a.size();
        for (int i = 1; i < N; i++) {
            if (a.get(i).equals(a.get(ptrIndex))) {
                continue;
            } else {
                ptrIndex += 1;
                a.set(ptrIndex, a.get(i));
            }
        }

        return ptrIndex + 1;
    }

    public static void main(String args[]) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        // int A[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        int A[] = {5000, 5000, 5000};
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < A.length; i++)
            array.add(A[i]);

        System.out.println(removeDuplicates.removeDuplicatesII(array));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);

        list.add(3);
        System.out.println(list);
    }
}
