
/**
 * DCP : Problem #115 [Hard]
 * This problem was asked by Google.
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
 * A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 */

// m = number of nodes in s tree and n = number of nodes in t tree
// Time complexity : O(m * n), worst case for skewed trees
// Space Complexity : O(m)

public class BinaryTreeSubtree {
    public static void main(String[] args)
    {
        BinaryTreeSubtree obj = new BinaryTreeSubtree();
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(2);
        s.right = new TreeNode(3);
        s.left.left = new TreeNode(4);
        s.left.right = new TreeNode(5);
//        s.left.right.left = new TreeNode(8);

        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(4);
        t.right = new TreeNode(5);

        boolean result = obj.isSubtree(t, s);
    System.out.println(result);
    }

    // returns true if t is a subtree of s
    public boolean isSubtree(TreeNode t, TreeNode s)
    {
        if (t == null && s == null)
            return  true;

        if (s != null)
        {
            // if the subtrees with current root doesn't match, continue checking for left and then right subtrees as well
            return isEqualSubtree(t, s) || isSubtree(t, s.left) || isSubtree(t, s.right);
        }
        return false;
    }

    // Utility function to check whether two subtrees are equal or not
    public boolean isEqualSubtree(TreeNode t, TreeNode s)
    {
        if (t == null && s == null)
            return true;
        if (t == null || s == null)
            return false;

        // checking if the data of both roots is equal, and then checking for left and right subtrees as well.
        return t.val == s.val && isEqualSubtree(t.left, s.left) && isEqualSubtree(t.right, s.right);
    }
}
