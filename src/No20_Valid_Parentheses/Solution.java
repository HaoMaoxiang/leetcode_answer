package No20_Valid_Parentheses;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Solution {

    public boolean isValid(String s) {
        boolean result = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character chr = s.charAt(i);
            switch (chr) {
                case '(':
                case '[':
                case '{': stack.push(chr); break;
                case ')': if (stack.empty() || stack.pop() != '(') result = false; break;
                case ']': if (stack.empty() || stack.pop() != '[') result = false; break;
                case '}': if (stack.empty() || stack.pop() != '{') result = false; break;
            }
            if (!result) break;
        }
        return stack.empty() && result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("((){[]})"));
    }
}
