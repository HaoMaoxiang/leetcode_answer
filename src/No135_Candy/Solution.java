package No135_Candy;

import java.util.Arrays;

/**
 * 老是想给孩子们发糖果，有 N 个孩子站成了一条直线，老师根据每一个孩子的表现情况，会预先给他们每个人都打好评分。
 * <p>
 * 你要按照以下要求帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子都至少应该有1个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，至少需要准备多少颗糖果呢？
 */
public class Solution {

    public int candy(int[] ratings) {
        int res = 0;
        if (ratings == null || ratings.length == 0) {
            return res;
        }
        int[] candies = new int[ratings.length];

        // 从左向右扫描一遍
        candies[0] = 1;
        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        // 从右向左扫描一遍
        res += candies[candies.length - 1];
        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
            res += candies[i];
        }
        return res;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ratings = new int[] {1,3,4,3,2,1};
        System.out.println(s.candy(ratings));
    }
}
