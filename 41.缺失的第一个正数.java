/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    /*
     * 原地hash，即目的是让第i个元素的值是i+1，即4应该放在下标3上，
     * 最后第一个不满足i=i+1的元素就是结果
     * 
     * 注意此处发生交换的条件，以及如果交换的目的地就已经满足条件了，就不要交换了（nums[n - 1] != n），否则会死循环，
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int n = nums[i];
            if (n > 0 && n != i + 1 && n <= len && nums[n - 1] != n) {
                swap(nums, i, n - 1);
                --i;
            }
        }
        int k = len + 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                k = 1 + i;
                break;
            }
        }
        return k;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end
