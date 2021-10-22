import java.util.Deque;
import java.util.LinkedList;

/**
 * DCP : Problem #27 [Easy]
 * This problem was asked by Facebook.
 * Given a string of round, curly, and square open and closing brackets, return whether the
 * brackets are balanced (well-formed).
 * For example, given the string "([])[]({})", you should return true.
 * Given the string "([)]" or "((()", you should return false.
 */

// Time Complexity : O(n) -> since for each character, we perform O(1) operation
// Space Complexity : O(n)

public class WellFormedBrackets {
  public static void main(String[] args) {
    String brackets = "{[}]{())}";//"";//"([])[]({})";

    boolean result = isWellFormed(brackets);
    System.out.println(result);
  }

  public static boolean isWellFormed(String brackets)
  {
      Deque<Character> leftBracketStack = new LinkedList<>();

      for (int i = 0; i < brackets.length(); i++)
      {
          Character bracket = brackets.charAt(i);
          // pushing only left brackets into stack
          if (bracket == '(' || bracket == '{' || bracket == '[')
              leftBracketStack.addFirst(bracket);
          else
          {
              // Unmatched right brackets
              if (leftBracketStack.isEmpty())
                  return false;

              // Mismatched right brackets
              Character stackTop = leftBracketStack.peek();
              if((bracket == ')' && stackTop != '(')
                      || (bracket == '}' && stackTop != '{')
                      || (bracket == ']' && stackTop != '['))
                  return false;

              // if matched, pop from stack
              leftBracketStack.removeFirst();
          }
      }
      return leftBracketStack.isEmpty();
  }
}
