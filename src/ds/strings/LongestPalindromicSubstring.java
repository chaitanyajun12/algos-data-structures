package ds.strings;

public class LongestPalindromicSubstring {

    static class PalindromeData {
        int palindromeStartIndex;
        int palindromeLength;
    }

    public static void main(String[] args) {
        
        boolean result = getLongestPalindromeSubstring("") == "" &&
                         getLongestPalindromeSubstring(null) == null &&
                         getLongestPalindromeSubstring("a") == "a" && 
                         getLongestPalindromeSubstring("abcd").equals("a") &&
                         getLongestPalindromeSubstring("aabbcc").equals("aa") && 
                         getLongestPalindromeSubstring("abba").equals("abba");
        System.out.println(result);

        result = getLongestPalindromicSubstringUsingDP("") == "" &&
                    getLongestPalindromicSubstringUsingDP(null) == null &&
                    getLongestPalindromicSubstringUsingDP("a") == "a" && 
                    getLongestPalindromicSubstringUsingDP("abcd").equals("a") &&
                    getLongestPalindromicSubstringUsingDP("aabbcc").equals("aa") && 
                    getLongestPalindromicSubstringUsingDP("abba").equals("abba");
        System.out.println(result);
    }

    /**
     * Gets the longest palindromic substring by the logic of traversing each 
     * character in the string assuming that it is the mid-point of the palindrome.
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    static String getLongestPalindromeSubstring(String str) {

        if (str == null || str.length() < 2)
            return str;

        int N = str.length();
        int maxPalindromeLength = 0;
        int startIndex = 0;
          
        for (int i = 0; i < N; i++) {

            PalindromeData pData = expandRangeToFindPalindrome(str, i, i);
            if (pData.palindromeLength > maxPalindromeLength) {
                startIndex = pData.palindromeStartIndex;
                maxPalindromeLength = pData.palindromeLength;
            }

            pData = expandRangeToFindPalindrome(str, i, i + 1);
            if (pData.palindromeLength > maxPalindromeLength) {
                startIndex = pData.palindromeStartIndex;
                maxPalindromeLength = pData.palindromeLength;
            }
        }
        
        return str.substring(startIndex, maxPalindromeLength);
    }

    static PalindromeData expandRangeToFindPalindrome(String str, int start, int end) {
        
        int N = str.length();      
        while (start >= 0 && end < N && str.charAt(start) == str.charAt(end)) {
            start--;
            end++;
        }      
        
        PalindromeData pData = new PalindromeData();
        pData.palindromeStartIndex = start + 1;
        pData.palindromeLength = end - start - 1; // (end - 1) - (start + 1) + 1

        return pData;
    }

    /**
     * Get the longest palindromic substring using dynamic programming.
     * Time complexity: O(n^2)
     * Space complexity: O(n^2)
     */
    static String getLongestPalindromicSubstringUsingDP(String str) {

        if (str == null || str.length() < 2)
            return str;

        int N = str.length();
        boolean pMatrix[][] = new boolean[N][N];

        // Strings of length = 1 will be palindromic
        for (int i = 0; i < N; i++) {
            pMatrix[i][i] = true;
        }

        // Check if strings of length = 2 are palindromic
        for (int i = 0; i < N - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                pMatrix[i][i + 1] = true;
            }
        }

        // For all strings of length > 2
        for (int i = 0; i < N - 2; i++) {
            for (int j = 2; j < N; j++) {            
                pMatrix[i][j] = pMatrix[i + 1][j - 1] && (str.charAt(i) == str.charAt(j));
            }
        }

        int maxPalindromeLength = 1;
        int maxPalindromeStartIndex = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (pMatrix[i][j] && (j - i + 1) > maxPalindromeLength) {
                    maxPalindromeLength = j - i + 1;
                    maxPalindromeStartIndex = i;
                }
            }
        }

        return str.substring(maxPalindromeStartIndex, maxPalindromeLength);
    }
     
}