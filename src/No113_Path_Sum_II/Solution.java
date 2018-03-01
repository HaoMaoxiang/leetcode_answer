package No113_Path_Sum_II;

import BasicDataStruct.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        helper(root, sum, path, result);
        return result;
    }

    private void helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && sum(path) == sum) {
            result.add(new LinkedList<>(path));
        }
        helper(root.left, sum, path, result);
        helper(root.right, sum, path, result);
        path.remove(path.size() - 1);
    }

    private int sum(List<Integer> path) {
        int sum = 0;
        for (Integer i : path) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;
        List<List<Integer>> pathSum = s.pathSum(root, 9);
        System.out.println(pathSum);
    }
}
