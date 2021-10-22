/**
 * DCP : Problem #46 [Hard] This problem was asked by Amazon.
 * Given a string, find the longest palindromic contiguous substring.
 * If there are more than one with the maximum length, return any one.
 * For example, the longest palindromic substring of "aabcdcb" is "bcdcb". The longest palindromic substring of "bananas" is "anana".
 */

// Time Complexity : O(n^2) - using DP ; O(n^2) - using method2
// Space Complexity : O(n^2) - using DP ; O(1) - using method2

public class LongestPalindromicSubstring {
  public static void main(String[] args) {
      String str = "aabcdcb";//"  ";//"bananas";
      String resultDP = getLongestPalindromicSubstringDP(str);
      System.out.println(resultDP);

      String resultMethod2 = getLongestPalindromicSubstringMethod2(str);
      System.out.println(resultMethod2);
  }

  // Solution using Dynamic Programming
  public static String getLongestPalindromicSubstringDP(String str)
  {
      if(str == null || str.equals(""))
          return "";

      boolean[][] dp = new boolean[str.length()][str.length()];
      int maxLength = 1, startIdx = 0;

      // all substrings of length 1 are palindrome, so set 'true'
      for (int i = 0; i < str.length(); i++)
      {
          dp[i][i] = true;
      }

      // checking for substrings of length 2
      for (int i = 0; i < str.length() - 1; i++)
      {
          if (str.charAt(i) == str.charAt(i + 1))
          {
              dp[i][i+1] = true;
              maxLength = 2;
              startIdx = i;
          }
      }

      // checking for substrings of length greater than 2; filling dp table diagonally : only top-right diagonal part of the table
      for (int strLength = 3; strLength <= str.length(); strLength++)
      {
          for (int i = 0; i < str.length() - strLength + 1; i++)
          {
              int j = i + strLength - 1;
              if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] == true)
              {
                  dp[i][j] = true;
                  if (strLength > maxLength)
                  {
                      maxLength = strLength;
                      startIdx = i;
                  }
              }
          }
      }
       return str.substring(startIdx, startIdx + maxLength);
  }

  // Solution using Expand Around Center concept - palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center.
  public static String getLongestPalindromicSubstringMethod2(String str)
  {
      if (str == null || str.length() < 1)
          return "";

      int startIdx = 0, endIdx = 0;

      for (int i = 0; i < str.length(); i++)
      {
          int oddSubstrLen = expandAroundCenter(str, i, i);
          int evenSubstrLen = expandAroundCenter(str, i, i+1);
          int maxLength = Math.max(oddSubstrLen, evenSubstrLen);

          // if new length is greater than previous maximum length of substring, then only set new start and end indices
          if (maxLength > endIdx - startIdx + 1)
          {
              startIdx = i - (maxLength - 1) / 2;
              endIdx = startIdx + maxLength - 1;
          }
      }
      return str.substring(startIdx, endIdx + 1);
  }

  public static int expandAroundCenter(String str, int start, int end)
  {
      while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end))
      {
          start--;
          end++;
      }
      // at this point both start & end are 1 step away from their respective correct indices for the string to be palindromic
      // returns length of palindromic substring
      return end - start - 1;
  }
}
