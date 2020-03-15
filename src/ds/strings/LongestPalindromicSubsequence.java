package ds.strings;

public class LongestPalindromicSubsequence {
    public static void main(String args[]) {
        boolean result = getLongestPalindromicSubsequence("") == 0 &&
                         getLongestPalindromicSubsequence("a") == 1 &&
                         getLongestPalindromicSubsequence(null) == 0 &&
                         getLongestPalindromicSubsequence("BBABCBCAB") == 7 &&  //BABCBAB
                         getLongestPalindromicSubsequence("aba") == 3 &&
                         getLongestPalindromicSubsequence("aa") == 2;

        System.out.println(result);
    }

    static int getLongestPalindromicSubsequence(String str) {
        if (str == null || str.length() == 0) return 0;
        if (str.length() == 1) return 1;

        return getLongestPalindromicSubsequenceWithArrays(str.toCharArray(), 0, str.length() - 1);
    }
    
    /**
     * Gets the longest palindromic subsequence using the same array.
     * Time complexity: O(2^n)
     * Space complexity: O(1)
     * @param strArray
     * @param start
     * @param end
     * @return
     */
    static int getLongestPalindromicSubsequenceWithArrays(char[] strArray, int start, int end) {        
        if (start > end) {
            return 0;
        } else if (start == end) {
            return 1;
        } else if (strArray[start] == strArray[end]) {
            return getLongestPalindromicSubsequenceWithArrays(strArray, start + 1, end - 1) + 2;
        }

        return Math.max(getLongestPalindromicSubsequenceWithArrays(strArray, start, end - 1), 
            getLongestPalindromicSubsequenceWithArrays(strArray, start + 1, end));
    }

    /**
     * This method creates substrings to get the longest palindromic subsequence.
     * Time complexity: O(2^n)
     * Space complexity: O(n^2)
     * @param str
     * @param start
     * @param end
     * @return
     */
    static int getLongestPalindromicSubsequenceInternal(String str, int start, int end) {
        if (start > end) {
            return 0;
        } else if (start == end) {
            return 1;
        } else if (str.charAt(start) == str.charAt(end)) {
            String s = str.substring(start + 1, end); // end - 1, because of substring end - 1 + 1
            return getLongestPalindromicSubsequenceInternal(s, 0, s.length() - 1) + 2;
        }

        String leftString = str.substring(start, end); // end - 1, because of substring end - 1 + 1
        String rightString = str.substring(start + 1, end + 1); // end, because of substring end + 1
        return Math.max(getLongestPalindromicSubsequenceInternal(leftString, 0, leftString.length() - 1), 
                getLongestPalindromicSubsequenceInternal(rightString, 0, rightString.length() - 1));
    }
}