package No14_Longest_Common_Prefix;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        StringBuffer result = new StringBuffer();
        int i = 0;
        while (true) {
            int j = 1;
            for (; j < strs.length; j++) {
                if (! (strs[j-1].length() > i && strs[j].length() > i && strs[j-1].charAt(i)==strs[j].charAt(i))) {
                    break;
                }
            }
            if (j == strs.length) {
                result.append(strs[j-1].charAt(i));
            } else {
                break;
            }
            i++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(new String[]{"c","c"}));
    }
}
