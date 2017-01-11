package com.ib.strings;

/**
 * Created by krishna.m1 on 15/12/16.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String value = "1";
        int count = 1, i, j;

        while (count < n) {
            StringBuilder newValue = new StringBuilder();
            i = 0;
            while (i < value.length()) {
                char ch = value.charAt(i);
                int chCount = 1;
                for (j = i + 1; j < value.length(); j++) {
                    if (value.charAt(j) != ch) {
                        break;
                    }

                    chCount += 1;
                }

                newValue.append(String.valueOf("" + chCount + ch));
                i = j;
            }

            value = newValue.toString();
            count += 1;
        }

        return value;
    }

    public static void main(String args[]) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(5));
    }
}
