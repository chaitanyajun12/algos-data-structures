package com.ctci.arraysstrings;

import java.util.Arrays;

/**
 * Created by krishna.m1 on 04/12/16.
 */
public class UniqueCharacters {

    private static boolean hasUniqueCharacters(String string) {
        int checker = 0;
        for(int i = 0; i < string.length(); i++) {
            int value = string.charAt(i) - 'a';
            System.out.println("value : " + value);
            if((checker & (1 << value)) > 0)
                return false;

            checker = checker | (1 << value);
        }

        return true;
    }

    private static String reverse(String str) {

        if(str == null  || str.length() == 0)
            return null;

        int n = str.length();
        int mid = (n - 1) / 2;
        char arr[] = str.toCharArray();
        for(int i = 0, j = (n - 1); i <= mid; i++, j--) {
            swap(arr, i, j);
        }

        return Arrays.toString(arr);
    }

    private static void swap(char arr[], int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void removeDuplicates(String str) {
        if(str == null) {
            return;
        }

        if(str.length() < 1) {
            return;
        }

        char arr[] = str.toCharArray();
        int n = arr.length;
        int k = 1;

        for(int i = 1; i < n; i++) {
            char value = str.charAt(i);
            int j;
            for(j = i - 1; j >= 0; j--) {
                if(str.charAt(j) == value) {
                    break;
                }
            }

            if(j < 0) {
                arr[k++] = str.charAt(i);
            }
        }

        for(int i = 0; i < k; i++) {
            System.out.print(arr[i]);
        }

        System.out.println();
    }

    private static void findKthCharacter(String str, int k) {
        if(str == null || str.length() < 2) {
            System.out.println("Not a valid string");
            return;
        }

        int sum = 0;
        for(int i = 1; i < str.length(); i+=2) {
            sum += Integer.parseInt(String.valueOf(str.charAt(i)));
            if(k <= sum) {
                System.out.println(str.charAt(i - 1));
                return;
            }
        }

        System.out.println(k + "st/th character does not exist");
    }

    public static void main(String args[]) {
        System.out.println(hasUniqueCharacters("aac"));
        System.out.println(reverse(""));
        removeDuplicates("aaaab");

        findKthCharacter("a1", 1);
    }
}
