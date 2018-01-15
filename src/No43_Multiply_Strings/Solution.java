package No43_Multiply_Strings;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 * <p>
 * Note:
 * <p>
 * 1. The length of both num1 and num2 is < 110.
 * 2. Both num1 and num2 contains only digits 0-9.
 * 3. Both num1 and num2 does not contain any leading zero.
 * 4. You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String result = "";
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        for (int i = num2.length() - 1; i >= 0; i--) {
            String bitProduct = bitMultiply(num1Array, num2Array[i], num2.length() - 1 - i);
            result = add(result, bitProduct);
        }

        return result;
    }

    private String bitMultiply(char[] numArray, char bit, int index) {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = numArray.length - 1; i >= 0; i--) {
            int product = (bit - '0') * (numArray[i] - '0') + carry;
            carry = product / 10;
            result.insert(0, product % 10);
        }
        if (carry > 0) {
            result.insert(0, carry);
        }
        for (int i = 0; i < index; i++) {
            result.append("0");
        }
        return result.toString();
    }

    private String add(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        StringBuilder strB1 = new StringBuilder(str1);
        StringBuilder strB2 = new StringBuilder(str2);
        while (strB1.length() < strB2.length()) {
            strB1.insert(0, 0);
        }
        while (strB2.length() < strB1.length()) {
            strB2.insert(0, 0);
        }

        int i = strB1.length() - 1;
        int carry = 0;
        while (i >= 0) {
            int bitSum = (strB1.charAt(i) - '0') + (strB2.charAt(i) - '0') + carry;
            carry = bitSum / 10;
            result.insert(0, bitSum % 10);
            i -= 1;
        }

        if (carry > 0) {
            result.insert(0, carry);
        }

        return result.toString();

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.multiply("123", "98"));
    }
}
