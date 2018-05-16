package No274_H_Index;

public class Solution {
    public int hIndex(int[] citations) {
        int res = 0;
        quickSort(citations, 0, citations.length - 1);
        for (int i = 0; i < citations.length; i++) {
            int h = i + 1;
            if (h == citations.length && citations[i] >= h) {
                res = h;
            } else if (citations[i] >= h && citations[i + 1] <= h) {
                res = h;
            }
        }
        return res;
    }

    private void quickSort(int[] nums, int left, int right) {
        int l = left, r = right;
        if (l > r) return;
        int p = nums[l];
        while (l < r) {
            while (l < r && nums[r] < p) r -= 1;
            while (l < r && nums[l] >= p) l += 1;
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        int temp = nums[l];
        nums[l] = nums[left];
        nums[left] = temp;
        quickSort(nums, left, l - 1);
        quickSort(nums, r + 1, right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{3, 0, 6, 1, 5};
        System.out.println(s.hIndex(nums));
    }
}
