/**
 * This problem was asked by Google.
 * Given the root of a binary tree, return a deepest node. For example, in the following tree,
 * return d.
 *       a
 *      / \
 *     b  c
 *    /
 *   d
 */

// Time Complexity : O(n), where n stands for total number of nodes.
// Space Complexity : O(n), worst case - n stack calls for skewed tree.

class Node<T> {
    T val;
    Node<T> left;
    Node<T> right;

    public Node (T val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class DeepestNodeInBinaryTree {
    Node result;
    int maxHeight;

  public static void main(String[] args) {
       /*Node n = new Node(1);
       n.left = new Node(2);
       n.right = new Node(3);
       n.left.left = new Node(4);
        */

      Node n = new Node('a');
      n.left = new Node('b');
      n.right = new Node('c');
      n.left.right = new Node('d');
      n.right.right = new Node('e');
      n.right.right.left = new Node('f');
      n.right.right.right = new Node('g');


   //   Node n = new Node(1);

       DeepestNodeInBinaryTree obj = new DeepestNodeInBinaryTree();
       Node deepestNode = obj.findDeepestNode(n);
       System.out.println(deepestNode.val);
  }

  public Node findDeepestNode (Node root)
  {
      result = root;
      maxHeight = -1;
      findDeepestNodeHelper(root, 0);
      return result;
  }

  public void findDeepestNodeHelper (Node root, int height)
  {
      if (root.left == null && root.right == null)
      {
          if (height > maxHeight)
          {
              maxHeight = height;
              result = root;
          }
          return;
      }

      if (root.left != null)
          findDeepestNodeHelper(root.left, height + 1);

      if (root.right != null)
          findDeepestNodeHelper(root.right, height + 1);
  }

}
