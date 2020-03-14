package ds.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubsequence {
    public static void main(String args[]) {
        String str = "abcd";
                
    }

    static Set<String> getSequencesList(String str) {
        int N = str.length();
        Set<String> sequences = new HashSet<>();
        for (int i = 0; i < N; i++) {
            sequences.add(Character.toString(str.charAt(i)));
        }

        int size = 1;
        do {
            for (int i = 0; i < N; i++) {
                for (int j = i + size; j < N; j++) {
                    System.out.println(str.substring(i, i + size) + str.substring(j, j + 1));
                    sequences.add(str.substring(i, i + size) + str.substring(j, j + 1));
                }
            }
            size++;
        } while (size < N);

        return sequences;
    }
}