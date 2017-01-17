package com.ib.strings;

/**
 * Created by krishna.m1 on 17/01/17.
 */
public class ZigZagString {
    public String convert(String a, int b) {
        if (a == null || b == 1) {
            return a;
        }

        StringBuilder rows[] = new StringBuilder[b];
        int N = a.length();
        int currentRow = 0;
        boolean goingDown = true;

        for (int i = 0; i < N; i++) {
            StringBuilder builder = rows[currentRow];
            if (builder == null) {
                builder = new StringBuilder();
                rows[currentRow] = builder;
            }

            builder.append(a.charAt(i));

            if (goingDown) {
                currentRow += 1;
                if (currentRow >= b) {
                    goingDown = false;
                    currentRow -= 2;
                }
            } else {
                currentRow -= 1;
                if (currentRow < 0) {
                    goingDown = true;
                    currentRow += 2;
                }
            }
        }

        N = rows.length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (rows[i] != null) {
                builder.append(rows[i].toString());
            }
        }

        return builder.toString();
    }

    public static void main(String args[]) {
        ZigZagString zigZagString = new ZigZagString();
        System.out.println(zigZagString.convert("ABCD", 3));
    }
}
