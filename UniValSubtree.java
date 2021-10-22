/**
 * DCP : Problem #8 [Easy]
 * This problem was asked by Google.
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 * Given the root to a binary tree, count the number of unival subtrees.
 * For example, the following tree has 5 unival subtrees:
 *    0
 *   / \
 *  1   0
 *     / \
 *    1   0
 *   / \
 *  1   1
 */

// TC : O(n) -> Starting at the leaves of the tree, and keeping track of the unival subtree count and value as we percolate back up
// SC : O(n) -> Stack calls

public class UniValSubtree {
    static int count;

    public static void main(String[] args) {
        count = 0;
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1);
        root.right.right = new TreeNode(0);

        isUniVal(root);
        System.out.println("Number of UniVal Subtrees = " + count);

    }

    public static boolean isUniVal(TreeNode root)
    {
        if(root == null)
            return true;

        boolean isLeftUnival = isUniVal(root.left);
        boolean isRightUnival = isUniVal(root.right);

        if(!isLeftUnival || !isRightUnival)
            return false;
        if(root.left != null && root.val != root.left.val)
            return false;
        if(root.right != null && root.val != root.right.val)
            return false;

        count++;
        return true;
    }
}
