package com.ib.strings;

/**
 * Created by krishna.m1 on 14/12/16.
 */
public class ReverseWords {
    public String reverseWords(String a) {
        if(a == null) {
            return null;
        }

        String[] words = a.replaceAll("\\s{2,}", " ").trim().split(" ");
        StringBuffer buffer = new StringBuffer();

        int N = words.length;
        for(int i = N - 1; i >= 0; i--) {
            buffer.append(words[i] + " ");
        }

        return buffer.toString().trim();
    }

    public static void main(String args[]) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords("the     " +
                "sky is blue"));
    }

}
