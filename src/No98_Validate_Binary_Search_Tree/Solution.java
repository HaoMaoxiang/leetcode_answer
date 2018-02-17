package No98_Validate_Binary_Search_Tree;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    /**
     * 利用中序遍历得到的序列是否有序判断是否二叉搜索树
     * @param root 根节点
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode pre = null;
        while(p != null || !stack.isEmpty()) {
            while(p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                if (pre != null && pre.val >= p.val) {
                    return false;
                }
                pre = p;
                p = p.right;

            }
        }
        return true;

    }

    /**
     * 利用二叉搜索树的性质，使用递归方法
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {

        if (root == null) return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(5);
//        TreeNode node5 = new TreeNode(6);
        root.left = node1; root.right = node2;
//        node1.left = null; node1.right = node3;
//        node2.left = node4; node2.right = node5;
        System.out.println(s.isValidBST(root));
    }
}
