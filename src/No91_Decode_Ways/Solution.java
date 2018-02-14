package No91_Decode_Ways;

import java.util.LinkedList;
import java.util.List;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * <p>
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * The number of ways decoding "12" is 2.
 */
class Solution {
    public int numDecodings(String s) {

        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int pre = 1, cur = 1, res = 1;
        for (int i = 1; i < s.length(); i++) {
            if (isValid(s.charAt(i-1), s.charAt(i))) {
                if (isValid(s.charAt(i))) {
                    res = cur + pre;
                } else {
                    res = pre;
                }
            } else {
                if (isValid(s.charAt(i))) {
                    res = cur;
                } else {
                    return 0;
                }
            }
            pre = cur;
            cur = res;
        }

        return res;
    }

    private boolean isValid(char pre, char cur) {
        return pre == '1' || (pre == '2' && cur <= '6');
    }

    private boolean isValid(char cur) {
        return '1' <= cur && cur <= '9';
    }
}
