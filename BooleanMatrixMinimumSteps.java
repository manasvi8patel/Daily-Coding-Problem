import java.util.Deque;
import java.util.LinkedList;

/**
 * DCP : Problem #23 [Easy] This problem was asked by Google.
 * You are given an M by N matrix consisting of booleans that represents a board. Each True boolean represents a wall. Each False boolean represents a tile you can walk on.
 * Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach the end coordinate from the start. If there is no possible path, then return null. You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.
 * For example, given the following board:
 * [[f, f, f, f], [t, t, f, t], [f, f, f, f], [f, f, f, f]] and start = (3, 0) (bottom left) and
 * end = (0, 0) (top left), the minimum number of steps required to reach the end is 7, since we
 * would need to go through (1, 2) because there is a wall everywhere else on the second row.
 */

class Coordinate {
    int x;  // row
    int y;  // column

    Coordinate(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;

        Coordinate coord = (Coordinate) obj;
        return (this.x == coord.x && this.y == coord.y);
    }
}

public class BooleanMatrixMinimumSteps {
  public static void main(String[] args) {
      boolean[][] matrix = {};//{{false, false, false, false}, {true, true, false, true} , {false, false, false, false}, {false, false, false, false}};

      Coordinate start = new Coordinate(3, 0);
      Coordinate end = new Coordinate(0, 0);

      int result = calculateMinimumSteps(matrix, start, end);
      System.out.println(result);
  }

  public static int calculateMinimumSteps(boolean[][] matrix, Coordinate start, Coordinate end)
  {
      if(!isValidCoordinate(start, matrix) || !isValidCoordinate(end, matrix))
          return -1;

      int minSteps = 1;
      int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
      Deque<Coordinate> coordQueue = new LinkedList<>();
      coordQueue.addLast(start);

      while(!coordQueue.isEmpty())
      {
          for(int q = coordQueue.size(); q > 0; q--)
          {
              Coordinate travelledCoord = coordQueue.removeFirst();

              // moves right, left, up, down as mentioned
              for(int[] dir : directions)
              {
                  Coordinate nextCoord = new Coordinate(travelledCoord.x + dir[0], travelledCoord.y + dir[1]);
                  // return if end is reached
                  if(nextCoord.equals(end))
                      return minSteps;

                  // adding next node to queue and marking travelled node True so that it is not being  visited again and again
                  if(isValidCoordinate(nextCoord, matrix))
                  {
                      coordQueue.addLast(nextCoord);
                      matrix[travelledCoord.x][travelledCoord.y] = true;
                  }
              }
          }
          minSteps++;
      }
      return -1;
  }

  // checks whether a coordinate lies within the mentioned constraints
  public static boolean isValidCoordinate(Coordinate coord, boolean[][] matrix)
  {
      return ((coord.x >= 0 && coord.x < matrix.length)
              && (coord.y >= 0 && coord.y < matrix[0].length)
              && !matrix[coord.x][coord.y]);
  }
}


