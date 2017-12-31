package No11_Container_With_Most_Water;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class Solution {

    /* 思路：
     * 容器的盛水量取决于容器的底和容器较短的那条边
     * 我们先取最大的底长，然后移动左右指针，记录最大容量，知道左右指针相遇
     * 指针移动方式：
     * 假设，left指针指向的值小于right指针指向的值，此时，如果我们将right指针像左移动，则分三种情况：
     * 1. 若移动后right指针的值大于left指针的值：高取决于left指针的值，但底变小了，所以容量也变小了；
     * 2. 若移动后right指针的值等于left指针的值：高取决于left指针的值，但底变小了，所以容量也变小了；
     * 3. 若移动后right指针的值小于left指针的值：高取决于right指针的值，但此时right指针的值小于left指针的值，同时底也变小了，所以容量也变小了。
     * 所以，移动高度较大的一侧，只会使容量变小，综上所述，应该移动高度较小一侧的指针。*/
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int area = (j - i) * Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
