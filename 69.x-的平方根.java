/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 */

// @lc code=start
class Solution {
    /*
     * 牛顿牛逼
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        double C = x, xi = x, xii;
        while (true) {
            xii = 0.5 * (xi + C / xi);
            if (Math.abs(xii - xi) < 1e-7)
                break;
            xi = xii;
        }
        return (int)xii;
    }
}
// @lc code=end
