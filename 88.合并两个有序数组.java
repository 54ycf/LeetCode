/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    /*
     * 从后往前的双指针，可以避免开辟新空间
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, P = nums1.length - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                nums1[P--] = nums2[p2--];
            } else if (p2 == -1) {
                nums1[P--] = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                nums1[P--] = nums1[p1--];
            } else {
                nums1[P--] = nums2[p2--];
            }
        }

    }
}
// @lc code=end
