package No105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int size = preorder.length;
        if (size == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        while (index < size && inorder[index] != preorder[0]) {
            index += 1;
        }
        int[] leftPreorder = new int[index];
        int[] rightPreorder = new int[size-index-1];
        System.arraycopy(preorder, 1, leftPreorder, 0, index);
        System.arraycopy(preorder, 1+index, rightPreorder, 0, size-index-1);

        int[] leftInorder = new int[index];
        int[] rightInorder = new int[size-index-1];
        System.arraycopy(inorder, 0, leftInorder, 0, index);
        System.arraycopy(inorder, index+1, rightInorder, 0, size-index-1);

        TreeNode left = buildTree(leftPreorder, leftInorder);
        TreeNode right = buildTree(rightPreorder, rightInorder);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
}
