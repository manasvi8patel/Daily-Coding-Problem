import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DCP : Problem #54 [Hard]
 * This problem was asked by Dropbox.
 * Sudoku is a puzzle where you're given a partially-filled 9 by 9 grid with digits. The objective is to fill the grid with the constraint that every row, column, and box (3 by 3 subgrid) must contain all of the digits from 1 to 9.
 * Implement an efficient sudoku solver.
 */

// Time Complexity : O(1) - because sudoku is always playing in grid of size 9x9, so there is no chance of scaling further with the size parameter.
// Space Complexity : O(1)

public class SudokuSolver {
  public static void main(String[] args) {
      List<List<Integer>> partialAssignments = new ArrayList<>();
      partialAssignments.add(Arrays.asList(5,3,0,0,7,0,0,0,0));
      partialAssignments.add(Arrays.asList(6,0,0,1,9,5,0,0,0));
      partialAssignments.add(Arrays.asList(0,9,8,0,0,0,0,6,0));
      partialAssignments.add(Arrays.asList(8,0,0,0,6,0,0,0,3));
      partialAssignments.add(Arrays.asList(4,0,0,8,0,3,0,0,1));
      partialAssignments.add(Arrays.asList(7,0,0,0,2,0,0,0,6));
      partialAssignments.add(Arrays.asList(0,6,0,0,0,0,2,8,0));
      partialAssignments.add(Arrays.asList(0,0,0,4,1,9,0,0,5));
      partialAssignments.add(Arrays.asList(0,0,0,0,8,0,0,7,9));

      solveSudoku(partialAssignments);

      for(List<Integer> sudokuRow : partialAssignments)
          System.out.println(sudokuRow);
  }

  public static boolean solveSudoku(List<List<Integer>> partialAssignments)
  {
      return solvePartialSudoku(0, 0, partialAssignments);
  }

  private static boolean solvePartialSudoku(int row, int col, List<List<Integer>> partialAssignments)
  {
    // On finishing solving 1 row, start with a new row
    if (col == partialAssignments.size())
    {
      col = 0;

      // When entire matrix has been filled without conflict
      if (++row == partialAssignments.size())
          return true;
    }

    // Skip non-empty entries
    if (partialAssignments.get(row).get(col) != 0)
        return solvePartialSudoku(row, col + 1, partialAssignments);

    // For empty entries we first check all the constraints by putting values one by one between 1 to 9.
      // It's substantially quicker to check if entry val conflicts with any of the constraints if we add it at (row, col) before adding it, rather than adding it and then checking all the constraints. This is because we are already starting with a valid configuration, and the only entry which if at all can cause a problem is entry val at  (row, col)

      for (int val = 1; val <= 9; val++)
      {
          if (isValidToAddEntry(val, row, col, partialAssignments))
          {
              partialAssignments.get(row).set(col, val);

              if (solvePartialSudoku(row, col + 1, partialAssignments))
                  return true;
          }
      }
      // Undo assignment if there is any constraint violation
      partialAssignments.get(row).set(col, 0);
      return false;
  }

  private static boolean isValidToAddEntry(int val, int row, int col, List<List<Integer>> partialAssignments)
  {
      // checking row constraints
      for (int i = 0; i < 9; i++)
      {
          if (val == partialAssignments.get(row).get(i))
              return false;
      }

      // checking column constraints
      for (int j = 0; j < 9; j++)
      {
          if (val == partialAssignments.get(j).get(col))
              return false;
      }

      // checking grid constraints
      int gridSize = (int) Math.sqrt(partialAssignments.size());
      // The complete grid is sub-divided into 3*3 sub-grids. This calculates the indices of sub-grid into which given (row, col) lies
      int gridRowIdx = row / gridSize, gridColIdx = col / gridSize;

      for (int r = 0; r < gridSize; r++)
      {
          for (int c = 0; c < gridSize; c++)
          {
              if (val == partialAssignments.get(gridRowIdx * gridSize + r).get(gridColIdx * gridSize + c))
                  return false;
          }
      }
      return true;
  }
}
