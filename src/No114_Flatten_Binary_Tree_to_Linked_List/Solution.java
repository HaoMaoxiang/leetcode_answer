package No114_Flatten_Binary_Tree_to_Linked_List;

import BasicDataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * For example,
 * Given
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */
public class Solution {
    //先序遍历，遍历结果存储在list集合中 O(N)的时间复杂度
    public void flatten1(TreeNode root) {
        List<TreeNode> nodes = preOrder(root);
        for (int i = 1; i < nodes.size(); i++) {
            nodes.get(i-1).left = null;
            nodes.get(i-1).right = nodes.get(i);
        }
    }

    private List<TreeNode> preOrder(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                list.add(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
        return list;

    }

    //结点有左子树，就将结点的右子树接在左子树的最右结点上，再将左子树变为右子树。
    public void flatten(TreeNode root) {
        TreeNode now = root;
        while (now != null) {
            if (now.left != null) {
                TreeNode pre = now.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = now.right;
                now.right = now.left;
                now.left = null;
            }
            now = now.right;
        }
    }
}
