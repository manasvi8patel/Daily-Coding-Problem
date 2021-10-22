import java.util.Arrays;

/**
 * DCP : Problem #4 [Hard]
 * This problem was asked by Stripe.
 * Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 * You can modify the input array in-place.
 */

public class SmallestPositiveNumber {
    public static void main(String[] args) {
        int[] nums = {-2, -5, -10}; //{10, 5, -1}; //{1, 2, 3, 4};//{2, 2, 3, 3}; //{0, 1, 2, 3}; //{12, 10, -1, 0, 1}; //{3, 4, -1, 1};

        int result = findSmallestPositiveNumber(nums);

        System.out.println("Smallest positive number = " + result);
    }

    public static int findSmallestPositiveNumber(int[] nums)
    {
        for(int i = 0; i < nums.length; i++)
        {
            while(nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
            {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));

        for(int j = 0; j < nums.length; j++)
        {
            if(nums[j] != j + 1)
                return j + 1;
        }
        return nums.length + 1;
    }
}
