/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 */

// @lc code=start
class Solution {
    /*
     * 二分的边界恼火😫
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int left = 0, right = x;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (x / mid < mid) {
                right = mid - 1;//next [left, mid-1]
            } else {
                left = mid; //next [mid...right]
            }
        }
        return left;
    }
}
// @lc code=end
