package No6_ZigZag_Conversion;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 */
public class Solution {

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            int j = i;
            while (j < s.length()) {
                result.append(s.charAt(j));
                if (i != 0 && i != numRows-1) {
                    int j2 = j + 2 * (numRows - i - 1);
                    if (j2 < s.length()) {
                        result.append(s.charAt(j2));
                    }
                }
                j = j + 2 * (numRows - 1);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convert("A", 1));
    }

}
