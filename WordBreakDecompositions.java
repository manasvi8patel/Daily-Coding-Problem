import java.util.*;

/**
 * DCP : Problem #22 [Medium]
 * This problem was asked by Microsoft.
 * Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.
 * For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].
 * Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
 */

// Time complexity : O(n^3) -> O(n) time taken implicitly to find whether a string is present in a set or not because in order to compute hash for the string we go through the string char by char.
// Space complexity : O(n)

public class WordBreakDecompositions {
    public static void main(String[] args) {
        String inputStr = "bedandben";//"";//"bedbathandbeyond";
        Set<String> dictionary = new HashSet<>(Arrays.asList("bed", "bath", "bedbath", "and", "beyond"));

        List<String> decompositions = decomposeIntoOriginalSentence(inputStr, dictionary);
        System.out.println(decompositions.toString());
    }

    public static List<String> decomposeIntoOriginalSentence(String inputStr, Set<String> dictionary)
    {
        List<String> decompositions = new ArrayList<>();
        if(inputStr.length() == 0)
            return decompositions;

        int[] wordLength = new int[inputStr.length()];
        Arrays.fill(wordLength, -1);

        for(int i = 0; i < inputStr.length(); i++)
        {
            // if substring of inputStr from 0 to i is a valid word, set wordLength[i] to length of the word
            if(dictionary.contains(inputStr.substring(0, i + 1)))
                wordLength[i] = i + 1;

            // if wordLength[i] == -1, look for j < i such that substring of inputStr from 0 to j has a valid decomposition ( not equal to -1) and
            // substring of inputStr from j + 1 to i is a valid dictionary word.
            if(wordLength[i] == -1)
            {
                for(int j = 0; j < i; j++)
                {
                    if(wordLength[j] != -1 && dictionary.contains(inputStr.substring(j + 1, i + 1))) {
                        wordLength[i] = i - j;
                        break;
                    }
                }
            }
        }

        // if not equal to -1, means the decomposition of string into valid words is possible. Thus, fetch valid words by its length stored in array.
        if(wordLength[wordLength.length - 1] != -1)
        {
            int strIdx = inputStr.length() - 1;
            while(strIdx >= 0)
            {
                decompositions.add(inputStr.substring(strIdx + 1 - wordLength[strIdx], strIdx + 1));
                strIdx -= wordLength[strIdx];
            }
            Collections.reverse(decompositions);
        }
        return decompositions;
    }
}
