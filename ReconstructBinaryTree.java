import java.util.*;
import java.util.LinkedList;

/**
 * DCP : Problem #48 [Medium]
 * This problem was asked by Google.
 * Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.
 * For example, given the following preorder traversal:
 * [a, b, d, e, c, f, g]
 * And the following inorder traversal:
 * [d, b, e, a, f, c, g]
 *You should return the following tree:
 *       a
 *     /   \
 *    b     c
 *   / \   / \
 *  d  e  f  g
 */

// Time Complexity : O(n) - building the hash table. However, recursive reconstruction takes O(1) constant time per node
// Space Complexity : O(n + h) - the size of hash table + maximum depth of function call stack

class BinaryTreeNode {
    Character data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode()
    {
    }
    BinaryTreeNode(Character data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    BinaryTreeNode(Character data, BinaryTreeNode left, BinaryTreeNode right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void printBT(BinaryTreeNode root)
    {
        Deque<BinaryTreeNode> levelOrderQueue = new LinkedList<>();
        levelOrderQueue.addLast(root);
        while(!levelOrderQueue.isEmpty())
        {
            if (levelOrderQueue.peekFirst() != null)
            {
                BinaryTreeNode removedNodeFromQueue = levelOrderQueue.removeFirst();
                System.out.print(" " + removedNodeFromQueue.data);
                if (removedNodeFromQueue.left != null)
                    levelOrderQueue.addLast(removedNodeFromQueue.left);

                if (removedNodeFromQueue.right != null)
                    levelOrderQueue.addLast(removedNodeFromQueue.right);
            }
        }
    }
}

public class ReconstructBinaryTree {
  public static void main(String[] args) {
      List<Character> preorder = Arrays.asList('a','b','d','e','c','f','g');
      List<Character> inorder = Arrays.asList('d','b','e','a','f','c','g');
      BinaryTreeNode bt = reconstructFromPreorderInorder(preorder, inorder);
      bt.printBT(bt);
  }

   public static BinaryTreeNode reconstructFromPreorderInorder(List<Character> preorder, List<Character> inorder)
   {
       Map<Character, Integer> nodeToInorderIndex = new HashMap<>();
       for (int i = 0; i < inorder.size(); i++)
       {
           nodeToInorderIndex.put(inorder.get(i), i);
       }

       return reconstructFromPreorderInorderHelper(preorder, 0, preorder.size(),
               nodeToInorderIndex, 0, inorder.size());
   }

   public static BinaryTreeNode reconstructFromPreorderInorderHelper(List<Character> preorder, int preorderStartIdx, int preorderEndIndex,
                                                                     Map<Character, Integer> nodeToInorderIndex, int inorderStartIdx, int inorderEndIdx)
   {
       if (preorderEndIndex <= preorderStartIdx || inorderEndIdx <= inorderStartIdx)
           return null;

       // The first node in preorder sequence is the root node. Thus, knowing root node of tree/subtree helps split inorder sequence into an inorder sequence for left subtree, followed by root, followed by right subtree.
       int inorderRootIndex = nodeToInorderIndex.get(preorder.get(preorderStartIdx));

       // A preorder traversal consists of root, followed by preorder traversal of left subtree, followed by preorder traversal of right subtree.
       // Therefore, the subsequence of 'leftSubtreeSize' nodes after root in the preorder traversal sequence is the preorder traversal sequence for the left subtree.
       int leftSubtreeSize = inorderRootIndex - inorderStartIdx;

       return new BinaryTreeNode(preorder.get(preorderStartIdx),
               // Recursively constructs left subtree
               reconstructFromPreorderInorderHelper(preorder, preorderStartIdx + 1, preorderStartIdx + 1 + leftSubtreeSize, nodeToInorderIndex, inorderStartIdx, inorderRootIndex),
               // Recursively constructs right subtree
               reconstructFromPreorderInorderHelper(preorder, preorderStartIdx + 1 + leftSubtreeSize, preorderEndIndex, nodeToInorderIndex, inorderRootIndex + 1, inorderEndIdx));
   }
}
