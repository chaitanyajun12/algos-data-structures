package com.ib.binarysearch;

import java.util.ArrayList;

/**
 * Created by krishna.m1 on 10/12/16.
 */
public class InsertionPosition {

    public static int searchInsert(ArrayList<Integer> a, int b) {
        int start = 0;
        int end = a.size() - 1;

        boolean isStart = false;

        while(start <= end) {
            int mid = (start + end) / 2;
            if (a.get(mid) == b) {
                return mid;
            } else if (a.get(mid) < b) {
                start = mid + 1;
                isStart = true;
            } else {
                end = mid - 1;
                isStart = false;
            }
        }

        return isStart ? start : (end < 0)? 0 : end;
    }


    public static void main(String args[]) {
        InsertionPosition ip = new InsertionPosition();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(7);

        System.out.println(ip.searchInsert(list, 4));
    }
}
