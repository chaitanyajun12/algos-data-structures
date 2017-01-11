package com.ib.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krishna.m1 on 15/05/16.
 */
public class FindOccurence {

    public int findCount(final List<Integer> a, int b) {

        int leftIndex = findLeftIndex(a, b);

        if(leftIndex == -1)
            return 0;

        int rightIndex = findRightIndex(a, b);

        return rightIndex - leftIndex + 1;
    }

    private int findLeftIndex(final List<Integer> a, int b) {

        int start = 0;
        int end = a.size() - 1;
        int mid;

        while (start <= end) {

            mid = (start + end) / 2;

            if(a.get(mid) == b) {

                if(mid - 1 >= 0) {

                    if(a.get(mid - 1) < b) {
                        return mid;
                    } else if(a.get(mid - 1) == b) {
                        end = mid - 1;
                    }

                } else {
                    return mid;
                }
            } else if (a.get(mid) < b) {

                start = mid + 1;
            } else {

                end = mid - 1;
            }
        }

        return -1;
    }

    private int findRightIndex(final List<Integer> a, int b) {

        int start = 0;
        int end = a.size() - 1;
        int mid;

        while (start <= end) {

            mid = (start + end) / 2;

            if(a.get(mid) == b) {

                if(mid + 1 < a.size()) {

                    if(a.get(mid + 1) > b) {
                        return mid;
                    } else if (a.get(mid + 1) == b) {
                        start = mid + 1;
                    }

                } else {
                    return mid;
                }

            } else if (a.get(mid) < b) {

                start = mid + 1;
            } else {

                end = mid - 1;
            }

        }

        return -1;

    }

    public static void main(String args[]) {

        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);

        System.out.println(new FindOccurence().findCount(input, 1));
    }
}
