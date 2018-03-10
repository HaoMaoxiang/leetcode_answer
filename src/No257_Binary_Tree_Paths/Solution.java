package No257_Binary_Tree_Paths;

import BasicDataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * For example, given the following binary tree:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * All root-to-leaf paths are:
 * <p>
 * ["1->2->5", "1->3"]
 */
public class Solution {

    //递归方法： dfs深度优先搜索
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, root.val+"", result);
        return result;
    }

    private void dfs(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(path);
        }
        if (root.left != null) {
            dfs(root.left, path + "->" + root.left.val, result);
        }
        if (root.right != null) {
            dfs(root.right, path + "->" + root.right.val, result);
        }
    }
}
