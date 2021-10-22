/**
 * DCP : Problem #84 [Medium]
 * This problem was asked by Amazon. Given a matrix of 1s and 0s, return
 * the number of "islands" in the matrix. A 1 represents land and 0 represents water, so an island
 * is a group of 1s that are neighboring whose perimeter is surrounded by water. For example, this
 * matrix has 4 islands.
 * 1 0 0 0 0
 * 0 0 1 1 0
 * 0 1 1 0 0
 * 0 0 0 0 0
 * 1 1 0 0 1
 * 1 1 0 0 1
 */

// Time Complexity : O(M*N)
// Space Complexity : O(M*N), considering stack calls space into account; otherwise no additional space required O(1)

public class NumberOfIslands {
  public static void main(String[] args) {
    int[][] matrix = /*{{1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}};*/

        {{1,0,0,0,0},
          {0,0,1,1,0}, {0,1,1,0,0},{0,0,0,0,0},{1,1,0,0,1},{1,1,0,0,1}};

    int result = calculateNumberOfIslands(matrix);
    System.out.println(result);
  }

  public static int calculateNumberOfIslands(int[][] matrix)
  {
      int number = 0;
      for (int i = 0; i < matrix.length; i++)
      {
          for (int j = 0; j < matrix[0].length; j++)
          {
              if (matrix[i][j] == 1)
              {
                  dfs(matrix, i, j);
                  number++;
              }
          }
      }
      return number;
  }

  public static void dfs(int[][] matrix, int i, int j)
  {
      // checking boundary constraints
      if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 0)
          return;

      matrix[i][j] = 0;
      dfs(matrix, i, j + 1);
      dfs(matrix,i + 1, j);
      dfs(matrix, i, j - 1);
      dfs(matrix,i - 1, 0);
      dfs(matrix, i - 1, j - 1);
      dfs(matrix, i - 1, j + 1);
      dfs(matrix, i + 1, j + 1);
      dfs(matrix, i + 1, j - 1);
  }
}
