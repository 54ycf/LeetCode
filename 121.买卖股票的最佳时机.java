/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int max = 0;
        for (int price : prices) {
            max = Math.max(max, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return max;
    }
}
// @lc code=end
