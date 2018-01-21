package No58_Length_of_Last_Word;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Example:
 * <p>
 * Input: "Hello World"
 * Output: 5
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        char[] c = s.toCharArray();
        int i = c.length - 1;
        while (i >= 0) {
            if (c[i] != ' ') {
                break;
            }
            i -= 1;
        }
        while (i >= 0) {
            if (c[i] != ' ') {
                len += 1;
            } else {
                break;
            }
            i -= 1;
        }
        return len;
    }
}
