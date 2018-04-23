package No226_Invert_Binary_Tree;

import BasicDataStruct.TreeNode;

/**
 * 翻转一棵二叉树。
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 转换为：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invertTree(left);
        invertTree(right);
        return root;
    }
}
