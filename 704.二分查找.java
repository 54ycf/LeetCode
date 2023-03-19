/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        return rec(0, nums.length - 1, nums, target);
    }

    private int rec(int l, int r, int[] nums, int target) {
        if (l > r) {
            return -1;
        }
        int mid = (l + r) / 2;
        int midV = nums[mid];
        if (midV < target) {
            return rec(mid + 1, r, nums, target);
        } else if (midV > target) {
            return rec(l, mid - 1, nums, target);
        } else {
            return mid;
        }
    }
}
// @lc code=end
