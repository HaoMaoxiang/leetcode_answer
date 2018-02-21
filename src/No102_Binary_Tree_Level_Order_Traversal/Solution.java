package No102_Binary_Tree_Level_Order_Traversal;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        TreeNode node = root;
        int curNum = 1;
        int nextNum = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        List<Integer> one = new LinkedList<>();
        while(!queue.isEmpty()) {
            node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                nextNum += 1;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextNum += 1;
            }
            one.add(node.val);
            if (one.size() == curNum) {
                curNum = nextNum;
                nextNum = 0;
                result.add(new LinkedList<>(one));
                one = new LinkedList<>();
            }

        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1; root.right = node2;
        node2.left = node3; node2.right = node4;
        System.out.println(s.levelOrder(root));
    }
}
