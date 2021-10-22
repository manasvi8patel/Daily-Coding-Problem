import java.util.HashMap;
import java.util.Map;

/**
 * DCP : Problem #13 [Hard]
 * This problem was asked by Amazon.
 * Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
 * For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 */

// Time Complexity : O(n) -> using sliding window technique to iterate through string only once.
// Space Complexity : O(1) -> number of english alphabets stored in Hash Map is fixed i.e. 26.

public class KDistinctCharacters {
    public static void main(String[] args) {
        String s = "ammaappaayyamayya";
        //"ababcabcdfababds"; //" "; //"";//"abcdabcda";//"abcba";
        int k = 3;
        //0; //2;

        String result = findLongestSubstring(s, k);
        System.out.println("Longest Substring with k Distinct Characters : " + result);
    }

    public static String findLongestSubstring(String s, int k)
    {
        // edge cases - assumed the result - to be clarified by interviewer
        if(k == 0 || s.length() == 0)
            return "";

        // Map keeps count of each character occurrences in the string inside a particular window with starting point as "start" and ending point as "end" variables
        Map<Character, Integer> charCountMap = new HashMap<>();
        int start = 0, end = 0;
        String result = "";

        while(end < s.length())
        {
            // increasing window size towards right, by inserting character into map and updating its count value accordingly
            Character endChar = s.charAt(end++);
            charCountMap.put(endChar, charCountMap.getOrDefault(endChar, 0) + 1);

            // reducing window size from left, if more than k distinct char present
            while(start < s.length() && charCountMap.size() > k)
            {
                Character startChar = s.charAt(start++);
                int startCharCount = charCountMap.get(startChar) - 1;

                if(startCharCount == 0)
                    charCountMap.remove(startChar);
                else
                    charCountMap.put(startChar, startCharCount);
            }

            // updating result only when current result length is longer that previous result length
            if(charCountMap.size() == k && result.length() < (end - start))
            {
                result = s.substring(start, end);
            }
        }
        return result;
    }
}
