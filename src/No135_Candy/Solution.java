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

    /*
     * 超时
     */
    public int candy(int[] ratings) {
        int candy = 0;
        if (ratings == null || ratings.length == 0) {
            return candy;
        }
        int flag = 0;
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        candy = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (i < ratings.length - 1 && ratings[i] >= ratings[i - 1] && ratings[i] >= ratings[i + 1]) {
                flag = i;
            }
            if (ratings[i] > ratings[i - 1]) {
                candy = candy + candies[i - 1] + 1;
                candies[i] = candies[i - 1] + 1;
            } else if (ratings[i] < ratings[i - 1]) {
                if (candies[i - 1] > 1) {
                    candy = candy + 1;
                } else {
                    for (int j = flag + 1; j <= i; j++) {
                        candy += 1;
                        candies[j] += 1;
                    }
                }
                candies[i] = 1;
            } else {
                candy = candy + 1;
                candies[i] = 1;
            }
            if (candies[flag] == candies[flag + 1] && ratings[flag] != ratings[flag + 1]) {
                candies[flag] += 1;
                candy += 1;
            }
            System.out.println("flag:" + flag + ", candy:" + candy + "\n candies:" + Arrays.toString(candies) + "\n");
        }
        return candy;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ratings = new int[] {1,3,4,3,2,1};
        System.out.println(s.candy(ratings));
    }
}
