import com.sun.jdi.InvalidTypeException;

/**
 * DCP : Problem #50 [Easy]
 * This problem was asked by Microsoft.
 * Suppose an arithmetic expression is given as a binary tree. Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.
 * Given the root to such a tree, write a function to evaluate it.
 * For example, given the following tree:
 *         *
 *        / \
 *       +   +
 *     /  \ /  \
 *    3   2 4   5
 * You should return 45, as it is (3 + 2) * (4 + 5).
 */

// Time Complexity : O(log n) - this tree cannot be skewed because the operators are such that they have to have 2 operands
// Space Complexity : O(log n)

class ArithmeticTree {
    char val;
    ArithmeticTree left;
    ArithmeticTree right;

    ArithmeticTree(char val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class ArithmeticTreeEvaluation {
  public static void main(String[] args) throws InvalidTypeException {
    ArithmeticTree root = new ArithmeticTree('*');
    root.left = new ArithmeticTree('+');
    root.right = new ArithmeticTree('+');
    root.left.left = new ArithmeticTree('3');
    root.left.right = new ArithmeticTree('2');
    root.right.left = new ArithmeticTree('4');
    root.right.right = new ArithmeticTree('5');

    int result = evaluateExpression(root);
    System.out.println(result);
  }

  public static int evaluateExpression(ArithmeticTree root) throws InvalidTypeException
  {
      if (root.left == null && root.right == null)
          return Integer.parseInt(String.valueOf(root.val));

      int left_value = evaluateExpression(root.left);
      int right_value = evaluateExpression(root.right);

      if (root.val == '+')
          return left_value + right_value;
      else if (root.val == '-')
          return left_value - right_value;
      else if (root.val == '*')
          return left_value * right_value;
      else if (root.val == '/')
          return left_value / right_value;
      else
          throw new InvalidTypeException("Operator not valid");
  }
}
