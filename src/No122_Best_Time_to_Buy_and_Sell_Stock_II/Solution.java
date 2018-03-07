package No122_Best_Time_to_Buy_and_Sell_Stock_II;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Solution {
    public int maxProfit(int[] prices) {

        if (prices.length <= 1) return 0;

        int buyPrice = prices[0];
        int result = 0;
        int i;
        for (i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                result += prices[i - 1] - buyPrice;
                buyPrice = prices[i];
            }
        }
        if (prices[i - 1] > buyPrice) {
            result += prices[i - 1] - buyPrice;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
