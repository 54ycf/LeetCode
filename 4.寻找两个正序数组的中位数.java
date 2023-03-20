/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    //分析边界情况太绕了！不会！只有跟着敲，还得再看看
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1; // 让nums1长度不大于nums2
            nums1 = nums2;
            nums2 = tmp;
        }
        int len1 = nums1.length, len2 = nums2.length;
        int leftNum = (len2 + len1 + 1) / 2; // 计算处于中位数的左边的数字个数，等效于len1+len2 / 2
        int left = 0, right = len1;
        while (left < right) {
            int i = left + (right - left + 1) / 2; // 这样不会执行到下标0，以保证nums1[i-1]不会越界
            int j = leftNum - i;
            if (nums1[i - 1] > nums2[j]) {
                // 下一轮搜索区间 [left, i-1 ]
                right = i - 1;
            } else {
                // 下一轮搜索区间 [i, right ]
                left = i;
            }
        }
        int i = left;
        int j = leftNum - i;
        int n1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int n1RightMin = i == len1 ? Integer.MAX_VALUE : nums1[i];
        int n2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int n2RightMin = j == len2 ? Integer.MAX_VALUE : nums2[j];
        if ((len1 + len2) % 2 == 1) {
            return Math.max(n1LeftMax, n2LeftMax);
        } else {
            return (double) (Math.max(n1LeftMax, n2LeftMax) + Math.min(n1RightMin, n2RightMin)) / 2;
        }
    }
}
// @lc code=end
