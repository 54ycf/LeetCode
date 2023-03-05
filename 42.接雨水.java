/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    /*
     * 每个指针想象成一个柱子，可以接水的容量是这个柱子的左边最大 和 右边最大（左右包括此柱） 中相对较小的值 减去 此桶的高度
     * 可以用前后缀分解（DP）左右和右左遍历两次得到两个前缀最大数组但是空间复杂度是On
     * 升级成双指针，每次的容量如何确定？如果左最大比右最大还大，则右边可以确定（木板效应），最多只能装右边最大-右边柱子高度。反之
     * 可见 灵茶山艾府 讲解
     */
    public int trap(int[] height) {
        int ans = 0;
        int L = 0, R = height.length - 1; // 左指针 右指针
        int L_suf = 0, R_suf = 0; // 左前缀最大值 右前缀最大值
        while (L <= R) {
            L_suf = Math.max(L_suf, height[L]);
            R_suf = Math.max(R_suf, height[R]);
            if (L_suf > R_suf) {
                ans += R_suf - height[R];
                --R;
            } else {
                ans += L_suf - height[L];
                ++L;
            }
        }
        return ans;
    }
}
// @lc code=end
