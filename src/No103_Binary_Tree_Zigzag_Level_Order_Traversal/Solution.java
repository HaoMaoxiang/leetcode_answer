package No103_Binary_Tree_Zigzag_Level_Order_Traversal;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        levelOrder(nodes, 0, result);
        return result;
    }

    private void levelOrder(List<TreeNode> nodes, int level, List<List<Integer>> result) {
        if (nodes.isEmpty()) return;
        List<Integer> one = new LinkedList<>();
        List<TreeNode> newNodes = new LinkedList<>();
        for (TreeNode node : nodes) {
            one.add(node.val);
            if (node.left != null) {
                newNodes.add(node.left);
            }
            if (node.right != null) {
                newNodes.add(node.right);
            }
        }
        if (level % 2 == 0) {
            result.add(one);
        } else {
            Collections.reverse(one);
            result.add(one);
        }
        levelOrder(newNodes, level + 1, result);
    }
}
