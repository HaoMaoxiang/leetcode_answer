package No94_Binary_Tree_Inorder_Traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree [1,null,2,3],
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,3,2].
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    /* 递归方法 */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root != null) {
            helper(root.left, result);
            result.add(root.val);
            helper(root.right, result);
        }
    }

    /* 非递归方法 */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1; root.right = node2;
        node1.left = null; node1.right = node3;
        node2.left = node4; node2.right = node5;

        System.out.println(s.inorderTraversal2(root));
    }
}
