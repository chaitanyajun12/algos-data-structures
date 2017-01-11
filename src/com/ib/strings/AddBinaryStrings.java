package com.ib.strings;

/**
 * Created by krishna.m1 on 14/12/16.
 */
public class AddBinaryStrings {
    public String addBinary(String a, String b) {
        if (a == null && b == null) {
            return null;
        }

        if (a == null || b == null) {
            return a == null ? b : a;
        }

        int offset = Math.abs(a.length() - b.length());
        if (a.length() > b.length()) {
            for (int i = 0; i < offset; i++) {
                b = "0" + b;
            }
        } else if (a.length() < b.length()) {
            for (int i = 0; i < offset; i++) {
                a = "0" + a;
            }
        }

        int N = a.length();
        int carry = 0;
        String sum = "";

        for (int i = N - 1; i >= 0; i--) {
            int n = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(i)) + carry;
            switch (n) {
                case 3:
                    carry = 1;
                    sum = "1" + sum;
                    break;
                case 2:
                    carry = 1;
                    sum = "0" + sum;
                    break;
                case 1:
                    carry = 0;
                    sum = "1" + sum;
                    break;
                case 0:
                    carry = 0;
                    sum = "0" + sum;
                    break;
            }
        }

        if (carry == 1) {
            sum = "1" + sum;
        }

        return sum;
    }

    public static void main(String args[]) {
        AddBinaryStrings addBinaryStrings = new AddBinaryStrings();
        System.out.println(addBinaryStrings.addBinary("1110000000010110111010100100111", "101001"));
    }
}
