import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * DCP : Problem #110 [Medium]
 * This problem was asked by Facebook.
 * Given a binary tree, return all paths from the root to leaves.
 * For example, given the tree:
 *      1
 *     / \
 *    2  3
 *      / \
 *     4  5
 * Return [[1, 2], [1, 3, 4], [1, 3, 5]].
 */

class NodeBinaryTree <T> {
    T val;
    NodeBinaryTree<T> left;
    NodeBinaryTree<T> right;

    NodeBinaryTree (T val)
    {
        this.val = val;
        left = null;
        right = null;
    }
}

public class BinaryTreePaths {
  public static void main(String[] args) {
    NodeBinaryTree<Integer> root = new NodeBinaryTree<>(1);
    root.left = new NodeBinaryTree<>(2);
    root.right = new NodeBinaryTree<>(3);
    root.right.left = new NodeBinaryTree<>(4);
    root.right.right = new NodeBinaryTree<>(5);

    BinaryTreePaths obj = new BinaryTreePaths();
    List<Deque<Integer>> pathLists = obj.findPaths(root);
    System.out.println(pathLists);
  }

  public List<Deque<Integer>> findPaths(NodeBinaryTree<Integer> root)
  {
      return findRootToLeafPath(root, new ArrayList<>(), new LinkedList<Integer>());
  }

  public List<Deque<Integer>> findRootToLeafPath(NodeBinaryTree<Integer> root, List<Deque<Integer>> result, Deque<Integer> path)
  {
      if (root == null)
          return null;

      path.addFirst(root.val);

      if (root.left == null && root.right == null)
      {
          result.add(path);
          return result;
      }

      findRootToLeafPath(root.left, result, path);
      findRootToLeafPath(root.right, result, path);

      path.removeFirst();

      return result;
  }

  public void printPath(Deque<Integer> path)
  {
    System.out.println(path);
  }
}
