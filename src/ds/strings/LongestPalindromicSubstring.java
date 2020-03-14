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
                         getLongestPalindromeSubstring("aabbcc").equals("aa");
        System.out.println(result);
    }

    /**
     * Gets the longest palindromic substring by the logic of traversing each 
     * character in the string assuming that it is the mid-point of the palindrome.
     * Time complexity: O(n^2)
     * Space complexity: O(n)
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
        





     
}