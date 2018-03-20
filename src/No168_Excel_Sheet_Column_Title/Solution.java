package No168_Excel_Sheet_Column_Title;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 */
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            n--;
            builder.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return builder.toString();
    }
}
