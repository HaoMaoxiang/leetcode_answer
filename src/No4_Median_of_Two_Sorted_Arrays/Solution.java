package No4_Median_of_Two_Sorted_Arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * <p>
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if ((m + n) % 2 == 0) {
            return (getKth(nums1, nums2, (m + n) / 2) + getKth(nums1, nums2, (m + n) / 2 + 1)) / 2;
        } else {
            return getKth(nums1, nums2, (m + n) / 2 + 1);
        }
    }

    private double getKth(int[] nums1, int[] nums2, int k) {
        if (nums1.length > nums2.length) {
            return getKth(nums2, nums1, k);
        }
        if (nums1.length == 0) {
            return nums2[k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[0], nums2[0]);
        }
        int c1 = Math.min(k / 2, nums1.length), c2 = k - c1;
        if (nums1[c1 - 1] < nums2[c2 - 1]) {
            return getKth(splitArray(nums1, c1, nums1.length), nums2, k - c1);
        } else {
            return getKth(nums1, splitArray(nums2, c2, nums2.length), k - c2);
        }
    }

    private int[] splitArray(int[] nums, int begin, int end) {
        int length = end - begin;
        int[] array = new int[length];
        System.arraycopy(nums, begin, array, begin - begin, end - begin);
        return array;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(new int[]{2}, new int[]{}));
//        System.out.println(s.getKth(new int[] {1,2,3}, new int[] {4,5,6}, 4));
//        System.out.println(Arrays.toString(s.splitArray(new int[] {1}, 1, 1)));
    }
}
