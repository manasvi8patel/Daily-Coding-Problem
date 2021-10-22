/**
 * DCP : Problem #62 [Medium] This problem was asked by Facebook.
 * There is an N by M matrix of zeroes. Given N and M, write a function to count the number of
 * ways of starting at the top-left corner and getting to the bottom-right corner. You can only move
 * right or down.
 * For example, given a 2 by 2 matrix, you should return 2, since there are two ways to get to
 * the bottom-right:
 * Right, then down Down, then right Given a 5 by 5 matrix, there are 70 ways to get to the
 * bottom-right.
 */

// Time Complexity : O(n * m)
// Space Complexity : O(n * m)

public class MatrixStartToEndWays {
  public static void main(String[] args) {
    int n = 3;//5;
    int m = 2;//5;

    int count = countWays(n, m);
    System.out.println(count);
  }

  public static int countWays(int n, int m)
  {
      int[][] countDP = new int[n][m];

      countDP[0][0] = 1;

      for (int i = 1; i < n; i++)
          countDP[i][0] = 1;

      for (int j = 1; j < m; j++)
          countDP[0][j] = 1;

      for (int i = 1; i < n; i++)
      {
          for (int j = 1; j < m; j++)
          {
              countDP[i][j] = countDP[i - 1][j] + countDP[i][j - 1];
          }
      }
      return countDP[n - 1][m - 1];
  }
}
