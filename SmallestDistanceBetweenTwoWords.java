/**
 * DCP : Problem #153 [Hard]
 * Find an efficient algorithm to find the smallest distance (measured in number of words) between any two given words in a string.
 * For example, given words "hello", and "world" and a text content of "dog cat hello cat dog dog hello cat world", return 1 because there's only one word "cat" in between the two words.
 */

// Time complexity : O(n) ; where n is number of words in the sentence
// Space Complexity : O(n) ; where n is number of words in the sentence

public class SmallestDistanceBetweenTwoWords {
  public static void main(String[] args) {
    String str = "hello cat dog dog hello cat world";
    String word1 = "hello", word2 = "world";
    int minDistance = minimumDistance(str, word1,word2);
    System.out.println(minDistance);
  }

  public static int minimumDistance(String str, String word1, String word2)
  {
      if (word1.equals(word2))
          return 0;

      String[] allWords = str.split(" ");
      int minDistance = allWords.length;
      int i = 0, prev = -1, n = allWords.length;

      while (i < n)
      {
          if (allWords[i].equals(word1) || allWords[i].equals(word2))
          {
              if (prev > -1 && !allWords[i].equals(allWords[prev]) && i - prev - 1 < minDistance)
              {
                  minDistance = i - prev - 1;
              }
              prev = i;
          }
          i += 1;
      }
      return minDistance;
  }
}
