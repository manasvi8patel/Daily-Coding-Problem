/**
 * DCP : Problem #40 [Hard]
 * This problem was asked by Google. Given an array of integers where every
 * integer occurs three times except for one integer, which only occurs once, find and return the
 * non-duplicated integer. For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13,
 * 13], return 19. Do this in O(N) time and O(1) space.
 *
 * Solution reference : https://www.geeksforgeeks.org/find-the-element-that-appears-once/
 */

public class ThreeTimesNonDuplicate {
  public static void main(String[] args) {
    int[] arr = {13, 19, 13, 13};//{6, 1, 3, 3, 3, 6, 6};
    int result = getNonDuplicate(arr);
    System.out.println(result);
  }

  public static int getNonDuplicate(int[] arr)
  {
      int ones = 0, twos = 0;
      int common;

      for (int num : arr)
      {
          // 'ones & num' gives the bits that are there in both 'ones' and new element from arr[]. We add these bits to 'twos' using bitwise OR
          twos = twos | (ones & num);
          // XOR new element from arr[] with previous 'ones' to get all bits appearing odd number of times
          ones = ones ^ num;
          // The common bits are those bits which appear third time. So these bits should not be there in both 'ones' and 'twos'.
          // Common_bit_mask contains all these bits as 0, so that the bits can be removed from 'ones' and 'twos'
          common = ~(ones & twos);
          // Remove common bits (the bits that appear third time) from 'ones'
          ones = ones & common;
          // Remove common bits (the bits that appear third time) from 'twos'
          twos = twos & common;
      }
      return ones;
  }
}
