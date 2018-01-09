package No28_Implement_strStr;

/**
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 */
public class Solution {

    public int kmp(String haystack, String needle) {
        int[] next = getNext(needle);
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i += 1;
                j += 1;
            } else {
                j = next[j];
            }
        }

        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    private int[] getNext(String str) {
        int[] next = new int[str.length()];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < str.length() - 1) {
            if (j == -1 || str.charAt(i) == str.charAt(j)) {
                i += 1;
                j += 1;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i += 1;
                j += 1;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr("mississippi", "issip"));
    }

}
