package No67_Add_Binary;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class Solution {
    public String addBinary(String a, String b) {

        char[] one = a.toCharArray();
        char[] two = b.toCharArray();

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = one.length - 1, j = two.length - 1;
        while (i >=0 && j >=0) {
            int digit = one[i]-'0' + two[j]-'0' + carry;
            carry = insertResultAndGetCarry(sb, digit);
            i--;
            j--;
        }

        while (i >= 0) {
            int digit = one[i] - '0' + carry;
            carry = insertResultAndGetCarry(sb, digit);
            i--;
        }

        while (j >= 0) {
            int digit = two[j] - '0' + carry;
            carry = insertResultAndGetCarry(sb, digit);
            j--;
        }
        if (carry == 1) {
            sb.insert(0, 1);
        }

        return sb.toString();

    }

    private int insertResultAndGetCarry(StringBuilder sb, int digit) {
        int carry;
        if (digit >=2) {
            sb.insert(0, digit - 2);
            carry = 1;
        } else {
            sb.insert(0, digit);
            carry = 0;
        }
        return carry;
    }
}
