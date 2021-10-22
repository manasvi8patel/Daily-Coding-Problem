/**
 * The class represents a Tree Node
 * where "val" stands for value of the node,
 * "left" points to its left subtree and
 * "right" points to its right subtree.
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode()
    {
    }
    TreeNode(int val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void printBT(TreeNode root)
    {
        if (root == null)
            return;

        System.out.print(" " + root.val);
        printBT(root.left);
        printBT(root.right);
    }
}
