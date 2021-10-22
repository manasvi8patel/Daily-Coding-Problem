import java.util.Arrays;

/**
 * DCP : Problem #126 [Medium]
 * This problem was asked by Facebook.
 * Write a function that rotates a list by k elements.
 * For example, [1, 2, 3, 4, 5, 6] rotated by two becomes [3, 4, 5, 6, 1, 2]. Try solving this without creating a copy of the list. How many swap or move operations do you need?
 */

// Time complexity : O(n)
// Space Complexity : O(1)

public class ArrayLeftRotation {
  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6};
    int k = 2;
    ArrayLeftRotation obj = new ArrayLeftRotation();
    obj.leftRotateArray(arr, k);

    for (int val : arr)
        System.out.print(val + " ");
  }

  public void leftRotateArray(int[] arr, int k)
  {
      int n = arr.length;
      k = k % n;

      int gcd = findGCD(n, k);

      for (int i = 0; i < gcd; i++)
      {
          int j = i;
          int temp = arr[i];
          while (true)
          {
              int next = j + k;
              if (next >= n)
                  next = next - n;
              if (next == i)
                  break;
              arr[j] = arr[next];
              j = next;
          }
          arr[j] = temp;
      }
  }

  public int findGCD(int a, int b)
  {
      if (b == 0)
          return a;
      else
          return findGCD(b, a % b);
  }
}
