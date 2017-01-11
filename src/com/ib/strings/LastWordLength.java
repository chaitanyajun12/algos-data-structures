package com.ib.strings;

/**
 * Created by krishna.m1 on 14/12/16.
 */
public class LastWordLength {
    public int lengthOfLastWord(final String a) {
        if (a == null || a.length() == 0) {
            return 0;
        }

        int N = a.length();
        int count = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (a.charAt(i) == ' ') {
                if (count != 0) {
                    break;
                }
            } else {
                count++;
            }
        }

        return count;
    }

    public static void main(String args[]) {
        LastWordLength lastWordLength = new LastWordLength();
        System.out.println(lastWordLength.lengthOfLastWord("Hello, World   "));
    }
}
