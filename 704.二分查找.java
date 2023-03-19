/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midV = nums[mid];
            if (midV < target) {
                left = mid + 1;
            } else if (midV > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
// @lc code=end
