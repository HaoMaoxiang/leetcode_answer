package No117_Populating_Next_Right_Pointers_in_Each_Node_II;

import BasicDataStruct.TreeLinkNode;

import java.util.LinkedList;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * <p>
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * <p>
 * Note:
 * <p>
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \    \
 * 4-> 5 -> 7 -> NULL
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
