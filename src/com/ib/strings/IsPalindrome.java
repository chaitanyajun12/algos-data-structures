package com.ib.strings;

/**
 * Created by krishna.m1 on 14/12/16.
 */
public class IsPalindrome {
    public int isPalindrome(String a) {
        if (a == null) {
            return 1;
        }

        int i = 0, j = a.length() - 1;
        while (true) {
            if (i > j) {
                break;
            }

            Character leftChar = a.charAt(i);
            Character rightChar = a.charAt(j);

            if ((Character.isAlphabetic(leftChar) || Character.isDigit(leftChar))
                    && (Character.isAlphabetic(rightChar) || Character.isDigit(rightChar))) {
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return 0;
                }
            } else {
                if (!(Character.isAlphabetic(leftChar) || Character.isDigit(leftChar))) {
                    i += 1;
                } else {
                    j -= 1;
                }

                continue;
            }

            i += 1;
            j -= 1;
        }

        return 1;
    }

    public static void main(String args[]) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome("\"A man, a plan, a canal: Panama\""));
    }
}
