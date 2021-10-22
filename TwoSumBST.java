import java.util.ArrayList;
import java.util.List;

/**
 * This problem was asked by Google.
 * Given the root of a binary search tree, and a target K, return two nodes in the tree whose sum equals K.
 * For example, given the following tree and K of 20
 *     10
 *    / \
 *   5  15
 *     / \
 *    11 15
 * Return the nodes 5 and 15.
 */

// Time complexity : O(n) ; Traversing the complete tree for inorder traversal
// Space Complexity : O(n) ; the sorted list will contain n elements

public class TwoSumBST {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(15);
    root.right.left = new TreeNode(11);
    root.right.right = new TreeNode(15);
    int k = 20;
    TwoSumBST obj = new TwoSumBST();
    List<Integer> result = obj.findTwoNodes(root, k);
    System.out.println(result);
  }

  // Method 1 - Inorder Traversal of BST gives the nodes in increasing order.
  public List<Integer> findTwoNodes(TreeNode root, int k)
  {
      List<Integer> inorderList = new ArrayList<>();
      List<Integer> result = new ArrayList<>();
      inorderBST(root, inorderList);

      int start = 0, end = inorderList.size() - 1;
      while (start < end)
      {
          int sum = inorderList.get(start) + inorderList.get(end);
          if (sum == k)
          {
              result.add(inorderList.get(start));
              result.add(inorderList.get(end));
              break;
          }
          else if (sum < k)
              start++;
          else
              end--;
      }
      return result;
  }

    public void inorderBST(TreeNode root, List<Integer> inorderList)
    {
        if (root == null)
            return;

        inorderBST(root.left, inorderList);
        inorderList.add(root.val);
        inorderBST(root.right, inorderList);
    }
}
