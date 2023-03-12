import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    /*
     * https://leetcode.cn/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
     * 将一个 尽可能小的「大数」 与前面的「小数」交换
     * 从右往左找到第一个升序邻居对，右邻居到尾一定是降序，找到右边大于左邻居到最小树
     * 两者交换，最后右邻居到末尾升序排列即可
     * 
     * 由于原来是降序，所以此处的升序用首尾对调会更快
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) { // 找到从右往左第一个升序对
                for (int j = len - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, i - 1, j);
                        break;
                    }
                }
                reverse(nums, i, len - 1);
                return;
            }
        }
        reverse(nums, 0, len - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Arrays的sort更方便但是慢一点
    public void reverse(int[] nums, int i, int j) {
        while (i <= j) {
            swap(nums, i, j);
            ++i;
            --j;
        }
    }
}
// @lc code=end
