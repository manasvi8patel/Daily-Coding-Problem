import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * DCP : Problem #117 [Easy]
 * This problem was asked by Facebook.
 * Given a binary tree, return the level of the tree with minimum sum.
 */

// Time complexity : O(n)
// Space Complexity : O(n)

public class BinaryTreeLevelSum {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(11);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(-2);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(-3);

    BinaryTreeLevelSum objBFS = new BinaryTreeLevelSum();
    int resultBFS = objBFS.findLevelWithMaxSumBFS(root);
    System.out.println("Method BFS = " + resultBFS);

    BinaryTreeLevelSum objDFS = new BinaryTreeLevelSum();
    int resultDFS = objDFS.findLevelWithMaxSumDFS(root);
    System.out.println("Method DFS = " + resultDFS);
  }

  // Method 1 - using BFS
  public int findLevelWithMaxSumBFS(TreeNode root)
  {
      int result = 0;
      int minSum = Integer.MAX_VALUE, level = 0;
      Deque<TreeNode> levelQueue = new LinkedList<>();
      levelQueue.addFirst(root);

      while (!levelQueue.isEmpty())
      {
          int queueSize = levelQueue.size();
          int sum = 0;
          level++;

          for (int i = 0; i < queueSize; i++)
          {
              TreeNode node = levelQueue.removeLast();
              if (node.left != null)
                  levelQueue.addFirst(node.left);
              if (node.right != null)
                  levelQueue.addFirst(node.right);

              sum += node.val;
          }

          if (sum < minSum)
          {
              minSum = sum;
              result = level;
          }
      }
      return result;
  }

    // Method 2 - using DFS
    public int findLevelWithMaxSumDFS(TreeNode root)
    {
        List<Integer> levelSumList = new ArrayList<>();
        findLevelWithMaxSumDFSHelper(root, levelSumList, 0);
        int minLevel = 0;
        for (int l = 0; l < levelSumList.size(); l++)
        {
            if (levelSumList.get(l) < levelSumList.get(minLevel))
                minLevel = l;
        }
        return  1 + minLevel;
    }

    public void findLevelWithMaxSumDFSHelper(TreeNode root, List<Integer> levelSumList, int level)
    {
        if (root == null)
            return;

        if (levelSumList.size() == level)
            levelSumList.add(root.val);
        else
        {
            levelSumList.set(level, levelSumList.get(level) + root.val);
        }
        findLevelWithMaxSumDFSHelper(root.left, levelSumList, level + 1);
        findLevelWithMaxSumDFSHelper(root.right, levelSumList, level + 1);
    }
}
