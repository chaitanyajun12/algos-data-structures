package com.ib.strings;

/**
 * Created by krishna.m1 on 14/12/16.
 */
public class StrStr {
    public int strStr(final String haystack, final String needle) {
        if (haystack == null || needle == null || haystack.length() == 0 || needle.length() == 0) {
            return -1;
        }

        int N = haystack.length();
        int M = needle.length();
        int i, j;

        for (i = 0; i <= N - M; i++) {
            for (j = 0; j < M; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }

            if (j == M) {
               return i;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr(" hello ", " h"));
    }
}
