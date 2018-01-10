package No13_Roman_to_Integer;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * 基本字符       I	V	X	L	C	D	M
 * 对应阿拉伯数字  1	5	10	50	100	500	1000
 * <p>
 * 计数规则：
 * 相同的数字连写，所表示的数等于这些数字相加得到的数，例如：III = 3
 * 小的数字在大的数字右边，所表示的数等于这些数字相加得到的数，例如：VIII = 8
 * 小的数字，限于（I、X和C）在大的数字左边，所表示的数等于大数减去小数所得的数，例如：IV = 4
 * 正常使用时，连续的数字重复不得超过三次
 * 在一个数的上面画横线，表示这个数扩大1000倍（本题只考虑3999以内的数，所以用不到这条规则）
 */

public class Solution {

    /* 从前向后遍历罗马数字，如果某个数比前一个数小，则加上该数。反之，减去前一个数的两倍然后加上该数 */
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('X', 10);
        map.put('C', 100);
        map.put('M', 1000);
        map.put('V', 5);
        map.put('L', 50);
        map.put('D', 500);

        int result = 0;
        if (s.length() == 0) {
            return result;
        }
        result += map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int front = map.get(s.charAt(i - 1));
            int back = map.get(s.charAt(i));
            if (front >= back) {
                result += back;
            } else {
                result = result - 2 * front + back;
            }
        }

        return result;
    }
}
