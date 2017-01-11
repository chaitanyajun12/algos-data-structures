package com.ib.arrays;

import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by krishna.m1 on 25/10/16.
 */
public class Test {


    public int[] getTopKFrequentElements() {

        class ValueComparator implements Comparator<Integer> {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

            public int compare(Integer i1, Integer i2){
                int diff = map.get(i2) - map.get(i1);
                return diff;
            }
        }

        return null;
    }

    public char get() {

        char ch = 'a';

        Character ch1 = ch;


        

        return ch;
    }


    public static void main(String args[]) {

        int a[] = {1, 2, 2, 3, 4, 5, 6, 6};


    }
}
