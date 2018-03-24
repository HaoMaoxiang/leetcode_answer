package No169_Majority_Element;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, elem = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (elem == nums[i]) {  //如果两个数相同，可抵消的个数加1
                count += 1;
            } else {    //两个数不同
                if (count > 0) {  //还有可抵消的个数，可抵消个数减1
                    count -= 1;
                } else {    //没有可抵消次数，重新选择元素
                    elem = nums[i];
                }
            }
        }
        return elem;
    }
}
