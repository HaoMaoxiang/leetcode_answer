package No167_Two_Sum_II_Input_array_is_sorted;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int start = 1, end = numbers.length;
        while (start < end) {
            int sum = numbers[start-1] + numbers[end-1];
            if (sum == target) {
                return new int[]{start, end};
            } else if (sum < target) {
                start += 1;
            } else {
                end -=1;
            }
        }
        return new int[2];
    }
}
