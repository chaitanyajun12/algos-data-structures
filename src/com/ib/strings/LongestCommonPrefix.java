package com.ib.strings;

import java.util.ArrayList;

/**
 * Created by krishna.m1 on 15/12/16.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(ArrayList<String> a) {
        if(a == null || a.size() == 0) {
            return "";
        }

        int minLength = a.get(0).length();
        int minLenIndex = 0;
        int i, j;

        for (i = 0; i < a.size(); i++) {
            if (a.get(i).length() < minLength) {
                minLength = a.get(i).length();
                minLenIndex = i;
            }
        }

        for (j = 0; j < minLength; j++) {
            String value = a.get(minLenIndex).substring(0, minLength - j);
            for (i = 0; i < a.size(); i++) {
                if (!value.equals(a.get(i).substring(0, minLength - j))) {
                    break;
                }
            }

            if (i == a.size()) {
                return value;
            }
        }

        return "";
    }

    public static void main(String args[]) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("cba");
        list.add("adc");
        System.out.println(longestCommonPrefix.longestCommonPrefix(list));
    }
}
