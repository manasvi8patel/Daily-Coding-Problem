import java.util.Arrays;
import java.util.List;

/**
 * DCP : Problem #118 [Easy]
 * This problem was asked by Google.
 * Given a sorted list of integers, square the elements and give the output in sorted order.
 * For example, given [-9, -2, 0, 2, 3], return [0, 4, 4, 9, 81].
 */

// Time complexity : O(n)
// Space Complexity : O(1)

public class SortedSquareList {
  public static void main(String[] args) {
      Integer[] nums = new Integer[] {-9, -2, 0, 2, 3};
                                    // {-8, -6, -2, 0, 5, 6, 9, 11};
      Integer[] result = sortedSquares(nums);
      List<Integer> resList = Arrays.asList(result);
      System.out.println(resList);
  }

  public static Integer[] sortedSquares(Integer[] nums) {
      int startIdx = 0, endIdx = nums.length - 1;
      Integer[] result = new Integer[nums.length];

      while(startIdx <= endIdx) {
          if(Math.abs(nums[startIdx]) < Math.abs(nums[endIdx])) {
              result[endIdx - startIdx] = nums[endIdx] * nums[endIdx];
              endIdx--;
          }
          else {
              result[endIdx - startIdx] = nums[startIdx] * nums[startIdx];
              startIdx++;
          }
      }
      return result;
  }
}
