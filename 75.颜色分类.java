/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    /*
    看似简单的双指针，注意一下几个问题：
    一个是和末尾交换后，如果交换后的cur不是1，就要回退一次，否则这个会被忽略
    还有就是cur的上限应该是<=右指针
     */

    public void sortColors(int[] nums) {
        int len = nums.length;
        int i = 0, j = len - 1, cur = 0;
        while (i < j && cur <= /*小于等于要注意*/j) {
            if (nums[cur] == 0) {
                swap(nums, cur, i);
                ++i;
            } else if (nums[cur] == 2) {
                swap(nums, cur, j);
                --j;
                if(nums[cur] != 1)
                    --cur; //注意！！
            }
            ++cur;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end
