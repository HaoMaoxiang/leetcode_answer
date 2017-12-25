package No3_Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    //先找最大的滑动窗口，然后循环减小窗口大小，时间超时。
    /**
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        int maxLength = set.size();
        if (maxLength == s.length())
            return maxLength;
        else {
            for (int i = maxLength; i > 1; i--) {
                for (int m = 0, n = m + i; n <= s.length(); m++, n++ ) {
                    if (!hasRepeatingCharacters(s.substring(m, n)))
                        return i;
                }
            }

        }
        return 1;
    }

    public boolean hasRepeatingCharacters(String substring) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < substring.length(); i++) {
            set.add(substring.charAt(i));
        }
        return set.size() != substring.length();
    }*/


    //利用Map<Character, Integer>，边遍历字符串边统计有没有重复的，时间复杂的O(n), 空间复杂的O(n)
    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s) || s.isEmpty() || s.length() == 0)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int FlagIndex = -1;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            if (map.containsKey(currentChar)) {
                int tempFlagIndex = map.get(currentChar);
                if (tempFlagIndex > FlagIndex) {
                    if (maxLength < i - FlagIndex - 1)
                        maxLength = i - FlagIndex - 1;
                    FlagIndex = tempFlagIndex;
                } else {
                    if (maxLength < i - FlagIndex)
                        maxLength = i - FlagIndex;
                }
            } else {
                if (maxLength < i - FlagIndex)
                    maxLength = i - FlagIndex;
            }
            map.put(currentChar, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("tmmzuxt"));
//        System.out.printf(s.hasRepeatingCharacters("abca") + "");
    }
}
