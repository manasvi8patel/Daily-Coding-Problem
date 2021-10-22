import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DCP : Problem #60 [Medium] This problem was asked by Facebook.
 * Given a multiset of integers, return whether it can be partitioned into two subsets whose sums are the same.
 * For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, it would return true,
 * since we can split it up into {15, 5, 10, 15, 10} and {20, 35}, which both add up to 55.
 * Given the multiset {15, 5, 20, 10, 35}, it would return false,
 * since we can't split it up into two subsets that add up to the same sum.
 */

// Time Complexity : O(m * n), where m is the subsetSum, and n is the number of array elements.
// Space Complexity : O(m * n)

public class EqualSubsetPartition {
  public static void main(String[] args) {
      List<Integer> multiset = new ArrayList<>(Arrays.asList(15, 5, 20, 10, 35));//(15, 5, 20, 10, 35, 15, 10));

      boolean result = canPartition(multiset);

    System.out.println(result);
  }

    public static boolean canPartition(List<Integer> nums) {
        int totalSum = 0;
        // find the sum of all array elements
        for (int num : nums)
            totalSum += num;

        // if the total sum is odd, the multiset cannot be divided into two subsets of equal sum
        if (totalSum % 2 != 0)
            return false;

        int subsetSum = totalSum / 2;
        int n = nums.size();

        boolean[][] dp = new boolean[n + 1][subsetSum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++)
        {
            int curr = nums.get(i - 1);
            for (int j = 0; j <= subsetSum; j++)
            {
                if (j < curr)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - curr];
            }
        }
        return dp[n][subsetSum];
    }
}
