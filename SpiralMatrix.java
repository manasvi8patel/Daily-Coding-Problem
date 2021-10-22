import java.util.ArrayList;
import java.util.List;

/**
 * This problem was asked by Amazon. Given a N by M matrix of numbers, print out the matrix in a
 * clockwise spiral. For example, given the following matrix: [[1, 2, 3, 4, 5], [6, 7, 8, 9, 10],
 * [11, 12, 13, 14, 15], [16, 17, 18, 19, 20]]
 * You should print out the following:
 * 1 2 3 4 5 10 15 20 19 18 17 16 11 6 7 8 9 14 13 12
 */

// Time Complexity : O(N) ; where N stands for total number of elements in the matrix, which is equal to number of rows * number of columns
// Space Complexity : O(1)

public class SpiralMatrix {
  public static void main(String[] args) {
      int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};//{{1,2,3,4},{5,6,7,8},{9,10,11,12}};//{};//{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
      List<Integer> spiralList = printSpiralMatrix(matrix);
      System.out.println(spiralList);
  }

  public static List<Integer> printSpiralMatrix(int[][] matrix)
  {
      List<Integer> spiralList = new ArrayList<>();
      if (matrix.length == 0)
          return spiralList;

      int rowBegin = 0, rowEnd = matrix.length - 1, colBegin = 0, colEnd = matrix[0].length - 1;
      int direction = 0;

      while (rowBegin <= rowEnd && colBegin <= colEnd)
      {
          if (direction == 0)
          {
              for (int i = colBegin; i <= colEnd; i++)
                  spiralList.add(matrix[rowBegin][i]);
              rowBegin++;
          }
          else if (direction == 1)
          {
              for (int i = rowBegin; i <= rowEnd; i++)
                  spiralList.add(matrix[i][colEnd]);
              colEnd--;
          }
          else if (direction == 2)
          {
              for (int i = colEnd; i >= colBegin; i--)
                  spiralList.add(matrix[rowEnd][i]);
              rowEnd--;
          }
          else if (direction == 3)
          {
              for (int i = rowEnd; i >= rowBegin; i--)
                  spiralList.add(matrix[i][colBegin]);
              colBegin++;
          }

          direction = (direction + 1) % 4;
      }
      return spiralList;
  }
}

