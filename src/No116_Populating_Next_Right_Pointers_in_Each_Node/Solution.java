package No116_Populating_Next_Right_Pointers_in_Each_Node;

import BasicDataStruct.TreeLinkNode;

import java.util.LinkedList;

/**
 * Given a binary tree
 * <p>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Note:
 * <p>
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        int curNodeNum = 1, nextNodeNum = 0;
        TreeLinkNode preNode = null;
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            if (preNode != null) {
                preNode.next = node;
            }
            preNode = node;
            curNodeNum -= 1;
            if (node.left != null) {
                queue.offer(node.left);
                nextNodeNum += 1;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextNodeNum += 1;
            }
            if (curNodeNum == 0) {
                node.next = null;
                preNode = null;
                curNodeNum = nextNodeNum;
                nextNodeNum = 0;
            }
        }
    }
}
