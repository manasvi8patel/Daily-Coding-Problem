import java.util.LinkedList;
import java.util.Queue;

/**
 * DCP : Problem #3 [Medium]
 * This problem was asked by Google.
 * Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.
 * For example, given the following TreeNode class
 * class TreeNode:
 *     def __init__(self, val, left=None, right=None):
 *         self.val = val
 *         self.left = left
 *         self.right = right
 * The following test should pass:
 * TreeNode = TreeNode('root', TreeNode('left', TreeNode('left.left')), TreeNode('right'))
 * assert deserialize(serialize(TreeNode)).left.left.val == 'left.left'
 */

public class TreeSerializeDeserialize {
    public  static void main(String[] args)
    {
        TreeNode rightSubTree = new TreeNode(3);
        TreeNode leftSubTree = new TreeNode(2, new TreeNode(4), null);
        TreeNode root = new TreeNode(1, leftSubTree, rightSubTree);
        String serializeResult = serializeTree(root);
        System.out.println("Serialized Tree : " + serializeResult);

        TreeNode deserializeResult = deserializeTree(serializeResult);
        System.out.print("Deserialized Tree : ");
        root.printBT(deserializeResult);
    }

    public static String serializeTree(TreeNode root)
    {
        if(root == null)
            return "";

        StringBuilder serializedSb = new StringBuilder();
        Queue<TreeNode> levelWiseTreeNodesList = new LinkedList<TreeNode>();
        levelWiseTreeNodesList.add(root);

        while(!levelWiseTreeNodesList.isEmpty())
        {
            TreeNode n = levelWiseTreeNodesList.poll();
            if(n == null)
            {
                serializedSb.append("o,");
                continue;
            }
            serializedSb.append(n.val).append(",");
            levelWiseTreeNodesList.add(n.left);
            levelWiseTreeNodesList.add(n.right);
        }
        return serializedSb.toString();
    }

    public static TreeNode deserializeTree(String serializedStr)
    {
        if(serializedStr.length() == 0 || serializedStr.equals(" "))
            return null;

        Queue<TreeNode> q = new LinkedList<>();
        String[] serializedArr = serializedStr.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(serializedArr[0]));
        q.add(root);

        for(int i = 1; i < serializedArr.length; i = i+2) {
            TreeNode parent = q.poll();
            if(!serializedArr[i].equals("o")) {
                TreeNode left = new TreeNode(Integer.parseInt(serializedArr[i]));
                q.add(left);
                parent.left = left;
            }
            if(!serializedArr[i + 1].equals("o")) {
                TreeNode right = new TreeNode(Integer.parseInt(serializedArr[i + 1]));
                q.add(right);
                parent.right = right;
            }
        }
        return root;
    }
}
