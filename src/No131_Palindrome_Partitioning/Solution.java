package No131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(s, result, list);
        return result;
    }

    private void helper(String s, List<List<String>> result, List<String> list) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String subString = s.substring(0, i);
            if (!isPalindrome(subString)) {
                continue;
            }
            list.add(subString);
            helper(s.substring(i), result, list);
            list.remove(list.size() - 1);
        }
    }

    private boolean isPalindrome(String str) {
        boolean res = true;
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                res = false;
                break;
            } else {
                left += 1;
                right -= 1;
            }
        }
        return res;
    }
}
