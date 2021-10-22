/**
 * DCP : Problem #151 [Medium]
 * Given a 2-D matrix representing an image, a location of a pixel in the screen and a color C, replace the color of the given pixel and all adjacent same colored pixels with C.
 * For example, given the following matrix, and location pixel of (2, 2), and 'G' for green:
 * B B W
 * W W W
 * W W W
 * B B B
 * Becomes
 * B B G
 * G G G
 * G G G
 * B B B
 */

// Time complexity : O(N); where N is total number of pixels. In worst case we might end up processing every pixel.
// Space Complexity : O(N); for the size of explicit stack call created when performing DFS

public class ColorMatrix {
  public static void main(String[] args) {
    char[][] image = {{'B', 'B', 'B'}, {'B','B','W'}, {'B','W','B'}};//{{'W', 'B', 'B'}, {'B','W','B'}, {'W','W','B'}, {'W','B','B'}};//{{'B', 'B', 'W'}, {'W','W','W'}, {'W','W','W'}, {'B','B','B'}};
    int[] coordinate = {1,1};//{2,2};
    char color = 'O';//'R';//'G';

    ColorMatrix obj = new ColorMatrix();
    obj.replaceColor(image, coordinate, color);

    for (int row = 0; row < image.length; row++)
    {
        for (int col = 0; col < image[0].length; col++)
        {
            System.out.print(image[row][col] + " ");
        }
        System.out.println();
    }
  }

  public void replaceColor(char[][] image, int[] coord, char color)
  {
      // Edge cases
      if (image.length == 0)
          return;

      int[][] moves = {{1,0},{0,1},{-1,0},{0,-1}};
      char givenPixelColor = image[coord[0]][coord[1]];

      for (int[] nextMove : moves)
      {
          int[] nextCoord = new int[2];
          nextCoord[0] = coord[0] + nextMove[0];
          nextCoord[1] = coord[1] + nextMove[1];
          image[coord[0]][coord[1]] = color;

          if (nextCoord[0] >= 0 && nextCoord[0] < image.length && nextCoord[1] >= 0 && nextCoord[1] < image[0].length && image[nextCoord[0]][nextCoord[1]] == givenPixelColor)
          {
              replaceColor(image, nextCoord, color);
          }
      }
  }
}
