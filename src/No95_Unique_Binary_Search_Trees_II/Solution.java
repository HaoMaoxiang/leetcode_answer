package No95_Unique_Binary_Search_Trees_II;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * <p>
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
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
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList<>();
        }
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> result = new LinkedList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftChild = helper(start, i - 1);
            List<TreeNode> rightChild = helper(i + 1, end);
            for (TreeNode left : leftChild) {
                for (TreeNode right : rightChild) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
