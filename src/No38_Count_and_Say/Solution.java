package No38_Count_and_Say;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 */
public class Solution {

    public String countAndSay(int n) {

        String result = "1";

        for (int i = 2; i <= n; i++) {
            String temp = result;
            result = "";
            int count = 0;
            int j;
            for (j = 0; j < temp.length(); j++) {
                if (j == 0 || temp.charAt(j - 1) == temp.charAt(j)) {
                    count += 1;
                } else {
                    result = result + count + temp.charAt(j - 1);
                    count = 1;
                }
            }
            result = result + count + temp.charAt(j - 1);
        }

        return result;
    }
}
