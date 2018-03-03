package No110_Balanced_Binary_Tree;

import BasicDataStruct.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example 1:
 * <p>
 * Given the following tree [3,9,20,null,null,15,7]:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Return true.
 * <p>
 * Example 2:
 * <p>
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * Return false.
 */
public class Solution {

    // O(n^2)时间复杂度
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(depth(root.left) - depth(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    // O(n)时间复杂度：采取后序遍历的方式
    public boolean isBalanced2(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int l = height(root.left);
        if (l == -1) return -1;
        int r = height(root.right);
        if (r == -1) return -1;
        if (Math.abs(l - r) > 1) return -1;
        return Math.max(l, r) + 1;
    }

}
