import java.util.HashMap;
import java.util.Map;

/**
 * Insert/Delete/Search into a Trie Data structure.
 * Reference :-
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/suffixprefix/Trie.java
 */

public class TrieImplementation {

    // Inner Class
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean wordEnd;

        public TrieNode()
        {
            children = new HashMap<>();
            wordEnd = false;
        }
    }

    final TrieNode root;
    public TrieImplementation()
    {
        root = new TrieNode();
    }

    public void insert(String word)
    {
        TrieNode currNode = root;
        for(char ch : word.toCharArray())
        {
            TrieNode nextNode = currNode.children.get(ch);
            if(nextNode == null) {
                nextNode = new TrieNode();
                currNode.children.put(ch, nextNode);
            }
            currNode = nextNode;
        }

        // indicates that the word ends here at this node
        currNode.wordEnd = true;
    }

    public boolean search(String word)
    {
        TrieNode currNode = root;
        for(char ch : word.toCharArray())
        {
            TrieNode nextNode = currNode.children.get(ch);
            if(nextNode == null)
                return false;

            currNode = nextNode;
        }

        // if the word exists, it return true otherwise false, as stored while insertion
        return currNode.wordEnd;
    }

    public void delete(String word)
    {
        delete(root, word, 0);
    }

    public boolean delete(TrieNode currNode, String word, int index)
    {
        if(word.length() == index)
        {
            // On reaching word end, check if it is true which means the word to be deleted exists
            if(!currNode.wordEnd)
                return false;

            currNode.wordEnd = false;
            // if current node has no further children in map, the node can only then be deleted
            return currNode.children.size() == 0;
        }

        char ch = word.charAt(index);
        TrieNode nextNode = currNode.children.get(ch);
        if(nextNode == null)
            return false;

        //check for next character in the word
        boolean canDeleteCurrNode = delete(nextNode, word, index + 1);

        if(canDeleteCurrNode)
        {
            currNode.children.remove(ch);
            return currNode.children.size() == 0;
        }
        return false;
    }
}
