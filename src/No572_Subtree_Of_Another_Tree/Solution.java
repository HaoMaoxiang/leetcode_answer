package No572_Subtree_Of_Another_Tree;

import BasicDataStruct.TreeNode;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * <p>
 * 示例 1:
 * 给定的树 s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 2:
 * 给定的树 s：
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 false。
 */
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean res = false;
        if (s != null && t != null) {
            if (s.val == t.val) {
                res = hasTree(s, t);
            }
            if (!res) {
                res = isSubtree(s.left, t);
            }
            if (!res) {
                res = isSubtree(s.right, t);
            }
        }
        return res;
    }

    private boolean hasTree(TreeNode s, TreeNode t) {
        if (t == null && s == null) {
            return true;
        }
        if (t == null || s == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return hasTree(s.left, t.left) && hasTree(s.right, t.right);
    }
}
