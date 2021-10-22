
/**
 * DCP : Problem #9 [Hard]
 * This problem was asked by Airbnb.
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
 * For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
 * Follow-up: Can you do this in O(N) time and constant space?
 */


public class MaximumNonAdjacentSum {
    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 5}; //{2, 4, 6, 2, 5};
        int maxSum = findMaxNonAdjSumFollowUp(nums);

        System.out.println("Maximum sum of non-adjacent numbers = " + maxSum);
    }

    public static int findMaxNonAdjSum(int[] nums)
    {
        if(nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++)
        {
            int incl = nums[i] + dp[i - 2];
            int excl = dp[i - 1];
            dp[i] = Math.max(incl, excl);
        }
        return dp[nums.length - 1];
    }

    public static int findMaxNonAdjSumFollowUp(int[] nums)
    {
        if(nums.length == 0)
            return 0;

        int incl = nums[0];
        int excl = 0;

        for(int i = 1; i < nums.length; i++)
        {
            int temp = incl;
            incl = Math.max(nums[i] + excl, incl);
            excl = temp;
        }
        return incl;
    }
}
