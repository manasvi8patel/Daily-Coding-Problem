import java.util.Arrays;

/**
 * DCP : Problem #2 [Hard]
 * This problem was asked by Uber.
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * Follow-up: what if you can't use division?
 */


public class AllProductExceptCurrent {
    public static void main(String[] args)
    {
//        int[] nums = {1, 2, 3, 4, 5};
//        int[] nums = {3, 2, 1};
//        int[] nums = {};      // edge case - to be clarified from the interviewer
//        int[] nums = {1};       // edge case - to be clarified from the interviewer
        int[] nums = {1, -2, 9, 80, -5};

        int[] result = calculateProductExceptCurrent(nums);
        System.out.println("result = " + Arrays.toString(result));
    }

    /**
     * Return a new list where each element at index 'i' of the list is the product of all elements of
     * list except the value at index i
     * @param nums Input number list
     * @return a new list where each element at index 'i' of the list is the product of all elements of
     * list except the value at index i
     */
    public static int[] calculateProductExceptCurrent(int[] nums)
    {
        if(nums.length == 0 || nums.length == 1)
            return new int[0];

        int[] product = new int[nums.length];
        int[] revProduct = new int[nums.length];
        int[] result = new int[nums.length];

        product[0] = nums[0];
        revProduct[nums.length - 1] = nums[nums.length - 1];

        for(int i = 1; i < nums.length; i++)
        {
            product[i] = product[i - 1] * nums[i];
        }
        for(int j = nums.length - 2; j >= 0; j--)
        {
            revProduct[j] = revProduct[j + 1] * nums[j];
        }

        System.out.println("Product = " + Arrays.toString(product));
        System.out.println("Reverse Product = " + Arrays.toString(revProduct));

        result[0] = revProduct[1];
        for(int i = 1; i < nums.length - 1; i++)
        {
            result[i] = product[i - 1] * revProduct[i + 1];
        }
        result[nums.length - 1] = product[nums.length - 2];

        return result;
    }
}
