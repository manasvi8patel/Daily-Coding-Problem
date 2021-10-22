import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * DCP : Problem #11 [Hard]
 * This problem was asked by Twitter.
 * Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.
 * For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
 * Hint: Try pre-processing the dictionary into a more efficient data structure to speed up queries.
 */

public class AutocompleteTrie {

    public static void main(String[] args) {
        String[] dict = {""}; //{"mobile","mouse","moneypot","monitor","mousepad"}; //{"bags","baggage","banner","box","cloths"}; //{"dog", "deer", "deal", "dear"};
        String query = " "; //""; //"bags"; //"de";        // Q. What if the query string is empty?
        List<String> autocompleteWordsResult = new ArrayList<>();

        TrieImplementation trieObj = new TrieImplementation();

        for(String word : dict)
        {
            trieObj.insert(word);
        }

        searchPrefix(trieObj.root, query, autocompleteWordsResult);

        System.out.println(autocompleteWordsResult);
    }

    public static void searchPrefix(TrieImplementation.TrieNode currNode, String query, List<String> autocompleteWordsResult)
    {
        for(char qChar : query.toCharArray())
        {
            TrieImplementation.TrieNode nextNode = currNode.children.get(qChar);
            if(nextNode == null)
                return;

            currNode = nextNode;
        }
        fetchAutocompleteWords(currNode, autocompleteWordsResult, query);
    }

    public static void fetchAutocompleteWords(TrieImplementation.TrieNode currNode, List<String> autocompleteWordsResult, String word)
    {
        if(currNode.wordEnd) {
            autocompleteWordsResult.add(word);
        }

        Map<Character, TrieImplementation.TrieNode> currChildren = currNode.children;
        if(currChildren.size() == 0)
            return;

        for(Character ch : currChildren.keySet())
        {
            word += ch;
            TrieImplementation.TrieNode nextNode = currChildren.get(ch);
            fetchAutocompleteWords(nextNode, autocompleteWordsResult, word);
            word = word.substring(0, word.length() - 1);
        }
    }
}
