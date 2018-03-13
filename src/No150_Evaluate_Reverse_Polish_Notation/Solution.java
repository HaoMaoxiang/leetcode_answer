package No150_Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p>
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int num = calculate(num1, num2, token);
                stack.push(num);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int calculate(int num1, int num2, String token) {
        int num = 0;
        switch (token) {
            case "+":
                num = num2 + num1;
                break;
            case "-":
                num = num2 - num1;
                break;
            case "*":
                num = num2 * num1;
                break;
            case "/":
                num = num2 / num1;
                break;
        }
        return num;
    }

    private boolean isOperator(String token) {
        if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
            return true;
        }
        return false;
    }
}
