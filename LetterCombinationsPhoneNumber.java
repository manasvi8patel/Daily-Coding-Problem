import java.util.*;

/**
 * This problem was asked by Yelp.
 * Given a mapping of digits to letters (as in a phone number), and a digit string, return all
 * possible letters the number could represent. You can assume each valid number in the mapping is a
 * single digit.
 * For example if {“2”: [“a”, “b”, “c”], 3: [“d”, “e”, “f”], …} then “23” should return [“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf"].
 */

// Time Complexity : O(3^N x 4^M), where N stands for number of digits in given digit string mapping to 3 letters (eg. 2, 3, 4 etc.) and M stands for number of digits in given digit string mapping to 4 letters (eg. 7, 9) . Also, N + M is the total length of given digit string.
// Space Complexity : O(1)

public class LetterCombinationsPhoneNumber {
    List<String> resultList;
    StringBuilder sbRes;
    Map<Character, List<Character>> digitToletters = new HashMap<Character, List<Character>>()
    {
        {
            put('2', new ArrayList<>(Arrays.asList('a','b','c')));
            put('3', new ArrayList<>(Arrays.asList('d','e','f')));
            put('4', new ArrayList<>(Arrays.asList('g','h','i')));
            put('5', new ArrayList<>(Arrays.asList('j','k','l')));
            put('6', new ArrayList<>(Arrays.asList('m','n','o')));
            put('7', new ArrayList<>(Arrays.asList('p','q','r','s')));
            put('8', new ArrayList<>(Arrays.asList('t','u','v')));
            put('9', new ArrayList<>(Arrays.asList('w','x','y','z')));
        }
    };

  public static void main(String[] args) {
    String digits = "239";//"2";//"";//"23";

    LetterCombinationsPhoneNumber obj = new LetterCombinationsPhoneNumber();
    List<String> res = obj.letterCombinations(digits);
    System.out.println(res);
  }

    public List<String> letterCombinations(String digits) {
        resultList = new ArrayList<>();
        sbRes = new StringBuilder();

        helperFunction(digits, 0);
        return resultList;
    }

    public void helperFunction(String digits, int digitIdx)
    {
        if (digitIdx == digits.length())
        {
            resultList.add(sbRes.toString());
            return;
        }

        List<Character> letters = digitToletters.get(digits.charAt(digitIdx));
        for(char letter : letters)
        {
            sbRes.append(letter);
            helperFunction(digits, digitIdx + 1);
            sbRes.deleteCharAt(sbRes.length() - 1);
        }
    }
}
