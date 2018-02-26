package No106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int size = inorder.length;
        if (size == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[size-1]);
        int index = 0;
        while (index < size && inorder[index] != root.val) {
            index += 1;
        }

        int[] leftInorder = new int[index];
        int[] rightInorder = new int[size-index-1];
        System.arraycopy(inorder, 0, leftInorder, 0, index);
        System.arraycopy(inorder, index+1, rightInorder, 0, size-index-1);

        int[] leftPostorder = new int[index];
        int[] rightPostorder = new int[size-index-1];
        System.arraycopy(postorder, 0, leftPostorder, 0, index);
        System.arraycopy(postorder, index, rightPostorder, 0, size-index-1);

        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);

        return root;
    }
}
