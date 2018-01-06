package No22_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * ["((()))","(()())","(())()","()(())","()()()"]
 */
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result, "", n, n);
        return result;
    }

    /* 使用回溯法：
     * 选择：1.加左括号 2.加右括号
     * 限制：1.如果左括号用完，不能再加左括号
     *      2.右括号个数不能大于左括号个数
     * 结束条件：左右括号个数都用完
     * 结束后的正确性：左右括号用完一定是正确解
     *
     * if (左右括号都已用完) {
     *     加入解集，返回
     * }
     * //否则开始试各种选择
     * if (还有左括号可以用) {
     *     加一个左括号，继续递归
     * }
     * if (右括号小于左括号) {
     *     加一个右括号，继续递归
     * }
     */
    public void backTrack(List<String> result, String subStr, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(subStr);
            return;
        }
        if (left > 0) {
            backTrack(result, subStr + '(', left - 1, right);
        }
        if (right > left) {
            backTrack(result, subStr + ')', left, right - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(3));
    }

}
