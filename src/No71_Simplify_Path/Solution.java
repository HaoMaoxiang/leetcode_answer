package No71_Simplify_Path;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * <p>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 * <p>
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class Solution {

    /*
     * /a/./b/../../c/
     */
    public String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/+");
        for (int i = 1; i < split.length; i++) {
            if ("..".equals(split[i])) {
                if (stack.size() != 0) {
                    stack.pop();
                }
            } else if (!".".equals(split[i])) {
                stack.add(split[i]);
            }
        }
        if (stack.size() == 0) {
            return "/";
        }
        while (stack.size() != 0) {
            res.insert(0,"/"+stack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.simplifyPath("/home/foo/.ssh/../.ssh2/authorized_keys/"));
    }
}
