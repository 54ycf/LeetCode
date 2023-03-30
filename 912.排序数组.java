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
    // 法2，归并
    public int[] sortArray(int[] nums) {
        // quickSort(nums, 0, nums.length - 1);
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int pivot = random.nextInt(left, right + 1);
        int pivotVal = nums[pivot];
        swap(nums, right, pivot);
        int mostRightSmaller = left; // 靠，原来写的 = 0， 难怪老出错
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

    private void mergeSort(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int i = l;
        int j = mid + 1;
        int[] tmp = new int[r - l + 1];
        int ind = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j])
                tmp[ind++] = nums[i++];
            else
                tmp[ind++] = nums[j++];
        }
        while (i <= mid) {
            tmp[ind++] = nums[i++];
        }
        while (j <= r) {
            tmp[ind++] = nums[j++];
        }
        ind = 0;
        for (int k = l; k <= r; k++) {
            nums[k] = tmp[ind++];
        }
    }
}
// @lc code=end
