/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    /*
     * 和53类似，此处不是on而是o nlogn
     * 还有就是每个i都应是初始化为1而不是0
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] f = new int[len];
        f[0] = 1;
        int max = 1;
        for (int i = 0; i < len; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    f[i] = Math.max(f[i], f[j] + 1);
            }
            max = Math.max(max, f[i]);
        }
        return max;
    }
}
// @lc code=end
