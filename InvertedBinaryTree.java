/**
 * DCP : Problem #83 [Medium]
 * This problem was asked by Google.
 * Invert a binary tree.
 * For example, given the following tree:
 *          a
 *        /  \
 *      b     c
 *    /  \   /
 *   d   e  f
 *
 * should become:
 *          a
 *         / \
 *        c   b
 *        \  / \
 *        f e  d
 */

// Time Complexity : O(n), where n stands for total number of nodes.
// Space Complexity : O(n), worst case - n stack calls for skewed tree.

class BinaryNode<T> {
    T val;
    BinaryNode<T> left;
    BinaryNode<T> right;

    BinaryNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public void printBinaryTree(BinaryNode<T> root)
    {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }
}

public class InvertedBinaryTree {
  public static void main(String[] args) {
      BinaryNode<Character> n = new BinaryNode<Character>('a');
      n.left = new BinaryNode<Character>('b');
      n.right = new BinaryNode<Character>('c');
      n.left.left = new BinaryNode<Character>('d');
      n.left.right = new BinaryNode<Character>('e');
      n.right.left = new BinaryNode<Character>('f');
      n.printBinaryTree(n);
      System.out.println();

      BinaryNode<Character> resultRoot = invertTree(n);
      resultRoot.printBinaryTree(resultRoot);
  }

  public static BinaryNode<Character> invertTree(BinaryNode<Character> root)
  {
      if (root == null)
          return null;

      BinaryNode<Character> leftSubTreeRoot = invertTree(root.left);
      BinaryNode<Character> rightSubTreeRoot = invertTree(root.right);
      root.left = rightSubTreeRoot;
      root.right = leftSubTreeRoot;

      return root;
  }
}
