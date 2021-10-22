import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DCP : Problem #42 [Hard]
 * This problem was asked by Google.
 * Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. If such a subset cannot be made, then return null.
 * Integers can appear more than once in the list. You may assume all numbers in the list are positive.
 * For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up
 * to 24.
 */

// Time Complexity : O(n * sum)
// Space Complexity : O(n * sum)

public class SubsetSum {
  public static void main(String[] args) {
      List<Integer> S = Arrays.asList();//Arrays.asList(2, 6, 4);//;Arrays.asList(2, 4, 6);//Arrays.asList(2, 2, 3);//Arrays.asList(12, 1, 61, 5, 9, 2);
      int k = 6;//0;//6;//4;//5;//24;

      List<Integer> result = getSubsetSum(S, k);
      System.out.println(result);
  }

  public static List<Integer> getSubsetSum(List<Integer> S, int k)
  {
      List<Integer> result = new ArrayList<>();
      boolean[][] dp = new boolean[S.size() + 1][k + 1];

      // If sum is 0, we can achieve it by not selecting any elements. Hence, true.
      for (int i = 0; i < dp.length; i++)
      {
          dp[i][0] = true;
      }

      // If number of elements is 0, we can not achieve any sum > 0. Hence, false.
      for (int i = 1; i < dp[0].length; i++)
      {
          dp[0][i] = false;
      }

      // Filling the remaining part of 'dp' table
      for (int r = 1; r < dp.length; r++)
      {
          for (int c = 1; c < dp[0].length; c++)
          {
              // If current element is greater than current sum, we don't include it. Else, we may or may not include the current element depending on if we include it do we still manage to make current sum from remaining above elements.
              if (S.get(r - 1) > c)
                  dp[r][c] = dp[r - 1][c];
              else
              {
                  // current sum can be achieved without including current element
                  if (dp[r - 1][c])
                      dp[r][c] = dp[r - 1][c];

                  // we include the current element, subtract from current sum and check whether remaining sum can be achieved using above current element in the dp table.
                  else
                      dp[r][c] = dp[r - 1][c - S.get(r - 1)];
              }
          }
      }

      // Finding elements which are included to achieve targeted sum
      int i = S.size(), j = k;
      while (i > 0 && j > 0 && dp[i][j])
      {
          // add to the result list only if we include the current element to make targeted sum
          if(!dp[i - 1][j])
          {
              result.add(S.get(i - 1));
              j -= S.get(i - 1);
          }
          i--;
      }
      return result;
  }
}
