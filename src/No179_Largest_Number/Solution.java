package No179_Largest_Number;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个非负整数的列表，重新排列它们的顺序把他们组成一个最大的整数。
 * <p>
 * 例如，给定 [3, 30, 34, 5, 9],最大的组成数是 9534330.
 * <p>
 * 注意: 结果可能非常大，所以您需要返回一个字符串而不是整数。
 */
public class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder builder = new StringBuilder();
        Integer[] ints = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ints[i] = nums[i];
        }
        Arrays.sort(ints, (o1, o2) -> {
            String str1 = String.valueOf(o1);
            String str2 = String.valueOf(o2);
            return (str2 + str1).compareTo(str1 + str2);
        });

        if (ints[0] == 0) return "0";

        for (Integer anInt : ints) {
            builder.append(anInt);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestNumber(new int[]{1,2,3,1}));
    }

}
