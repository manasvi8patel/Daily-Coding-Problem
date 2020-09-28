import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * This problem was recently asked by Google.
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * Bonus: Can you do this in one pass?
 */

public class TwoNumberSum {
    public static void main(String[] args)
    {
        List<Integer> nums = Arrays.asList(10, 15, 3, 7);
        int k = 17;

        boolean result = checkSumOfTwoNumbers(nums, k);
        System.out.println("Are any two numbers from the list adding up to " + k + " : " + result);
    }

    // Approach 1 - TC : O(N) ; SC : O(N)
    public static boolean checkSumOfTwoNumbers(final List<Integer> numbers, final int k)
    {
        // edge case
        if(numbers.isEmpty())
            return false;

        // List that holds numbers previous to current number
        List<Integer> numsBefore = new ArrayList<>();

        for(int numCurr : numbers)
        {
            int remVal = k - numCurr;
            if(!numsBefore.contains(remVal))
                numsBefore.add(numCurr);
            else
                return true;
        }
        return false;
    }

/**
 * Approach 2 - TC : O(N logN) ; SC : O(1)
 *
 *  public static boolean checkSumOfTwoNumbers(List<Integer> nums, int k)
 *     {
 *         // edge case
 *         if(nums.isEmpty())
 *             return false;
 *
 *         Collections.sort(nums);
 *         int begin = 0, end = nums.size() - 1;
 *
 *         while(begin < end)
 *         {
 *             if(nums.get(begin) + nums.get(end) > k)
 *                 end--;
 *             else if(nums.get(begin) + nums.get(end) < k)
 *                 begin++;
 *             else
 *                 return true;
 *         }
 *         return false;
 *     }
  */
}
