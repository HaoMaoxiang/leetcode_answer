package No337_House_Robber_III;

import BasicDataStruct.TreeNode;

/**
 * 小偷又发现一个新的可行窃的地点。 这个地区只有一个入口，称为“根”。 除了根部之外，每栋房子有且只有一个父房子。 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋形成了一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 在不触动警报的情况下，计算小偷一晚能盗取的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * 能盗取的最高金额 = 3 + 3 + 1 = 7.
 * <p>
 * 示例 2:
 * <p>
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * 能盗取的最高金额 = 4 + 5 = 9.
 */
public class Solution {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = left[1] + right[1] + root.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}
