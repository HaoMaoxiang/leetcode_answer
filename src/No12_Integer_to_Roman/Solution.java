package No12_Integer_to_Roman;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer, convert it to a roman numeral.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Solution {
    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();

        Map<Integer, String> map = new HashMap<>();
        String[] roman = new String[] {"I", "IV", "V", "IX", "X", "XL", "L",
                "XC", "C", "CD", "D", "CM", "M"};
        int[] integer = new int[] {1, 4, 5, 9, 10, 40, 50,
                90, 100, 400, 500, 900, 1000};
        for (int i = 12; num != 0; i--) {
            while (num >= integer[i]) {
                sb.append(roman[i]);
                num -= integer[i];
            }
        }

        return sb.toString();
    }
}
