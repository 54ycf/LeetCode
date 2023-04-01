import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    /*
     * dp[i]代表凑到i元钱最少需要多少硬币，然后每次向后的时候没一种情况都看看
     * 这里的优化是 Arrays.fill(dp, amount + 1); 用amount+1而不是Integer_MAX是为了避免溢出，也少做一些判断

     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        Arrays.sort(coins);
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length && i - coins[j] >= 0; ++j) {
                dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
// @lc code=end
