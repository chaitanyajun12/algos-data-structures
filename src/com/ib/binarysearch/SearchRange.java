package com.ib.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krishna.m1 on 10/12/16.
 */
public class SearchRange {

    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(findLeft(a, 0, a.size() - 1, b));
        list.add(findRight(a, 0, a.size() - 1, b));
        return list;
    }

    public int findRight(List<Integer> list, int start, int end, int k) {

        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (list.get(mid) == k && (mid == list.size() - 1 || (mid + 1 < list.size() && list.get(mid + 1) > k))) {
            return mid;
        } else if (k < list.get(mid)) {
            return findRight(list, start, mid - 1, k);
        } else {
            return findRight(list, mid + 1, end, k);
        }
    }

    public int findLeft(List<Integer> list, int start, int end, int k) {
        if(start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (list.get(mid) == k && (mid == 0 || (mid - 1) >= 0 && list.get(mid - 1) < k)) {
            return mid;
        } else if (k > list.get(mid)) {
            return findLeft(list, mid + 1, end, k);
        } else {
            return findLeft(list, start, mid - 1, k);
        }
    }

    public static void main(String args[]) {
        SearchRange searchRange = new SearchRange();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(7);
        list.add(8);
        list.add(8);
        list.add(10);
        System.out.println(searchRange.searchRange(list, 8));
    }
}


/*
else {
        if (mid == list.size() - 1 || (mid + 1 < arr.size() && list.get(mid + 1) > k)) {
        return mid;
        }
        }
*/
