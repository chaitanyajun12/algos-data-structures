package com.ib.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krishna.m1 on 15/12/16.
 */
public class Intersection {
    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        if (a == null || b == null) {
            return null;
        }

        int i = 0, j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < a.size() && j < b.size()) {
            if (a.get(i).equals(b.get(j))) {
                list.add(a.get(i));
                i += 1;
                j += 1;
            } else if (a.get(i) < b.get(j)) {
                i += 1;
            } else {
                j += 1;
            }
        }

        return list;
    }

    public static void main(String args[]) {
        Intersection intersection = new Intersection();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(10000000);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(10000000);

/*
        list1.add(2);
        list1.add(3);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(3);
        list2.add(5);
*/

        System.out.println(intersection.intersect(list1, list2));
    }

}
