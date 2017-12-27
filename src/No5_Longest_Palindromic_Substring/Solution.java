package No5_Longest_Palindromic_Substring;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 */
public class Solution {

    //枚举算法，算法遍历字符串，以每个字符或两个一样的字符为中心，向两边查找对称字符，进而找到最长的字符串。
    public String longestPalindrome(String s) {
        String result = null;
        if (s.length() < 2) {
            result = s;
        }
        int max = 0;
        int subStartPoint = 0;
        //以一个字符为中心
        for (int i = 0; i < s.length(); i++) {
            int tempMax = testTwoSide(s, i, i);
            if (max < tempMax) {
                max = tempMax;
                subStartPoint = i - max / 2;
            }
        }

        //以两个字符为中心
        for (int i = 1; i < s.length(); i++) {
            int tempMax = testTwoSide(s, i-1, i);
            if (max < tempMax) {
                max = tempMax;
                subStartPoint = i - max / 2;
            }
        }

        result = s.substring(subStartPoint, subStartPoint + max);
        return result;
    }

    private int testTwoSide(String s, int low, int high) {
        int max = 0;
        if (low == high) {
            low -= 1;
            high += 1;
            max = 1;
        }
        while (low>=0 && high < s.length() && s.charAt(low)==s.charAt(high)) {
            low -= 1;
            high += 1;
            max += 2;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("abcddcbe"));
    }
}
