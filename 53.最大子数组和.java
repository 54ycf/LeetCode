/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    /*
     * DP思路，f[i]表示以nums[i]结尾的子数组的最大值
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] f = new int[len];
        f[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
            max = Math.max(max, f[i]);
        }
        return max;
    }
    // 另一种解法，见官方：线段树求解最长公共上升子序列问题
}
// @lc code=end
