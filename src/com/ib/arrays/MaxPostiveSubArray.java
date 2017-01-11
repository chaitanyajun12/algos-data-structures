package com.ib.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by krishna.m1 on 07/05/16.
 */
public class MaxPostiveSubArray {

    class Element {
        public int sum;
        public int length;
        public int startIndex;

        public Element(int sum, int length, int startIndex) {
            this.sum = sum;
            this.length = length;
            this.startIndex = startIndex;
        }

        @Override
        public String toString() {
            return "sum : " + sum + ", "
                    + "length : " + length + ", "
                    + "startIndex " + startIndex;
        }
    }

    public ArrayList<Integer> maxset(ArrayList<Integer> a) {

        if(a == null)
            return a;

        ArrayList<Element> maxList = new ArrayList<>();
        int N = a.size();

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        boolean start = false;
        boolean subArrayStart = true;
        int startIndex = -1;


        for(int i = 0; i < N; i++) {

            if(!start && a.get(i) < 0)
                continue;

            start = true;

            if(subArrayStart) {
                startIndex = i;
                subArrayStart = false;
            }

            if(a.get(i) >= 0) {
                sum = sum + a.get(i);
            } else {

                if(sum >= maxSum) {

                    maxSum = sum;
                    if(sum > maxSum)
                        maxList.clear();
                    maxList.add(new Element(sum, (i - startIndex), startIndex));
                }

                sum = 0;
                startIndex = -1;
                subArrayStart = true;
            }
        }

        if(!start)
            return new ArrayList<>();

        if(sum >= maxSum) {
            if(sum > maxSum)
                maxList.clear();
            maxList.add(new Element(sum, N - startIndex, startIndex));
        }

        int resIndex = 0, resLen = Integer.MIN_VALUE, maxLenCount = 0;
        int minIndex = 0, minIndexVal = Integer.MAX_VALUE;

        for(int i = 0; i < maxList.size(); i++) {

            if(maxList.get(i).length > resLen) {
                resLen = maxList.get(i).length;
                maxLenCount = 1;
                resIndex = i;
            } else if(maxList.get(i).length == resLen) {
                maxLenCount++;
            }

            if(maxList.get(i).startIndex < minIndexVal) {
                minIndexVal = maxList.get(i).startIndex;
                minIndex = i;
            }
        }

        int resultIndex = maxLenCount > 1 ? minIndex : resIndex;

        ArrayList<Integer> res = new ArrayList<>();
        startIndex = maxList.get(resultIndex).startIndex;
        int endIndex = maxList.get(resultIndex).startIndex + maxList.get(resultIndex).length;
        for(int i = startIndex; i < endIndex; i++)
            res.add(a.get(i));

        return res;
    }

    public ArrayList<Integer> maxSet(ArrayList<Integer> a) {

        if(a == null)
            return a;

        int N = a.size();

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int currIndex = 0, minIndex = 0;
        int maxLength = Integer.MIN_VALUE;
        boolean start = false;


        for(int i = 0; i < N; i++) {

            if(!start && a.get(i) < 0) {
                currIndex++;
                continue;
            }

            start = true;

            if(a.get(i) >= 0) {

                sum += a.get(i);

            }

            if(a.get(i) < 0 || (i + 1) >= N) {

                if(sum > maxSum) {

                    maxSum = sum;
                    maxLength = (i - currIndex);
                    minIndex = currIndex;

                } else if(sum == maxSum) {

                    int currLength = (i - currIndex);
                    if(currLength > maxLength) {
                        maxLength = currLength;
                    } else if(currLength == maxLength) {
                        if(currIndex < minIndex) {
                            minIndex = currIndex;
                        }
                    }
                }

                sum = 0;
                currIndex = i + 1;
            }
        }

        if(!start)
            return null;

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = minIndex; i < minIndex + maxLength; i++) {
            result.add(a.get(i));
        }

        return result;
    }

    public ArrayList<Integer> maximumSet(ArrayList<Integer> a) {

        int sum = 0;
        int maxSum = 0;

        ArrayList<Integer> maxArray = new ArrayList<>();
        ArrayList<Integer> newArray = new ArrayList<>();

        for (Integer num : a) {

            if(num >= 0) {

                sum += num;
                newArray.add(num);

            } else {

                sum = 0;
                newArray = new ArrayList<>();
            }

            if(maxSum < sum || ((maxSum == sum) && newArray.size() > maxArray.size())) {
                maxSum = sum;
                maxArray = newArray;
            }
        }

        return maxArray;
    }

    public static void main(String args[]) {

        ArrayList<Integer> input = new ArrayList<>();
        //1, 2, 5, -7, 2, 5
        input.add(1);
        input.add(2);
        input.add(5);
        input.add(-7);
        input.add(2);
        input.add(5);

        input = new MaxPostiveSubArray().maximumSet(input);
        System.out.println(input.toString());
    }
}
