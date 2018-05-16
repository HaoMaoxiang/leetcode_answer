package No236_Lowest_Common_Ancestor_Of_A_Binary_Tree;

import BasicDataStruct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一棵二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义： “对于有根树T的两个结点u、v，最近公共祖先表示一个结点x，满足x是u、v的祖先且x的深度尽可能大。”（一个节点也可以是它自己的祖先）
 * <p>
 * _______3______
 * /              \
 * ___5__          ___1__
 * /      \        /      \
 * 6      _2       0       8
 * /  \
 * 7   4
 * 例如，节点5和节点1的最近公共祖先是节点3；节点5和节点4的最近公共祖先是节点5，因为根据定义，一个节点可以是它自己的祖先。
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> Ppath = new ArrayList<>();
        List<TreeNode> Qpath = new ArrayList<>();
        findPath(root, p, new ArrayList<>(), Ppath);
        findPath(root, q, new ArrayList<>(), Qpath);
        for (TreeNode a : Ppath) {
            System.out.print(a.val);
        }

        for (TreeNode a : Qpath) {
            System.out.print(a.val);
        }
        TreeNode res = root;
        for (int i = 1, j = 1; i < Ppath.size() && j < Qpath.size(); i++, j++) {
            if (Ppath.get(i) == Qpath.get(i)) res = Qpath.get(i);
            else break;
        }
        return res;
    }

    private void findPath(TreeNode root, TreeNode node, List<TreeNode> temp, List<TreeNode> path) {
        if (root == null) return;
        temp.add(root);
        if (root == node) {
            path = new ArrayList<>(temp);
            return;
        }
        if (root.left != null) {
            findPath(root.left, node, temp, path);
        }
        if (root.right != null) {
            findPath(root.right, node, temp, path);
        }
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(-1);
        TreeNode p = new TreeNode(4);
        TreeNode q = new TreeNode(8);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-2);
        root.left.right = p;
        root.left.left.left = q;
        s.lowestCommonAncestor(root, p, q);
    }
}
