/**
 * DCP : Problem #31 [Easy] This problem was asked by Google.
 * The edit distance between two strings refers to the minimum number of character insertions, deletions, and substitutions required to change one string to the other. For example, the edit distance between “kitten” and “sitting” is three: substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.
 * Given two strings, compute the edit distance between them.
 */

// Time Complexity : O(m * n) -> m, n - length of the two strings
// Space Complexity : O(m * n) -> can be reduced to O(min(m, n)) - as at a time we only require 2 rows of dp table : current row & previous row

public class EditDistance {
  public static void main(String[] args) {
    String fromStr = "kitten";
    String toStr = "sitting";
    int editDistance = calculateEditDistance(fromStr, toStr);
    System.out.println(editDistance);
  }

  public static int calculateEditDistance(String fromStr, String toStr)
  {
      int fromStrLength = fromStr.length();
      int toStrLength = toStr.length();

      // table to store sub-problems calculating distance between prefixes of two strings
      int[][] dp = new int[fromStrLength + 1][toStrLength + 1];

      for (int i = 0; i <= fromStrLength; i++)
      {
          for (int j = 0; j <= toStrLength; j++)
          {
              // fromStr is empty, so add all the characters of toStr
              if (i == 0)
                  dp[i][j] = j;
              // toStr is empty, so delete all the characters of fromStr
              else if (j == 0)
                  dp[i][j] = i;
              else if (fromStr.charAt(i - 1) == toStr.charAt(j - 1))
                  dp[i][j] = dp[i - 1][j - 1];
              else
              {
                  int substituteLast = dp[i - 1][j - 1];
                  int insertLast = dp[i][j - 1];
                  int deleteLast = dp[i - 1][j];
                  dp[i][j] = 1 + Math.min(substituteLast, Math.min(insertLast, deleteLast));
              }
          }
      }
      return dp[fromStrLength][toStrLength];
  }
}
