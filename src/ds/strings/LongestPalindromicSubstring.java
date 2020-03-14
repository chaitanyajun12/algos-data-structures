package ds.strings;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "abba";
        int N = str.length();
        int maxPalindromeLength = 0;
          
        for (int i = 0; i < N; i++) {
            maxPalindromeLength = Math.max(maxPalindromeLength, 
                                           expandRangeToFindPalindrome(str, i, i));
            maxPalindromeLength = Math.max(maxPalindromeLength, 
                                           expandRangeToFindPalindrome(str, i, i + 1));
        }
          
        System.out.println("Max palindrome length: " + maxPalindromeLength);
      }
        
      static int expandRangeToFindPalindrome(String str, int start, int end) {
          
          int N = str.length();      
          while (start >= 0 && end < N && str.charAt(start) == str.charAt(end)) {
              start--;
              end++;
          }      
          
          return end - start - 1;
      }
        
      static boolean isPalindrome(String str) {
    
          if (str == null || str.length() < 2) 
              return true;
            
          int start = 0;
          int N = str.length();
          int end = N - 1;
                    
          while(start <= end)
          {
            if (str.charAt(start) != str.charAt(end))
                return false;
    
            start++;
            end--;
          }
                    
          return true;          
      }    
}