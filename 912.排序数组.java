import java.util.Random;

/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {
    Random random = new Random();

    // 法1，快排
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int pivot = random.nextInt(left, right + 1);
        int pivotVal = nums[pivot];
        swap(nums, right, pivot);
        int mostRightSmaller = left; //靠，原来写的 = 0， 难怪老出错
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotVal) {
                swap(nums, mostRightSmaller++, i);
            }
        }
        swap(nums, right, mostRightSmaller);
        quickSort(nums, left, mostRightSmaller - 1);
        quickSort(nums, mostRightSmaller + 1, right);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end
