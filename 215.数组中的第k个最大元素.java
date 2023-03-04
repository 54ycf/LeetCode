import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findK(nums, k, 0, nums.length - 1);
    }

    private int findK(int[] nums, int k, int l, int r) {
        int pivot = nums[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (nums[j] <= pivot) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, r);
        int rank = r - i;
        if (k == rank)
            return nums[i + 1];
        else if (k > rank) {
            return findK(nums, k - rank, l, i);
        } else {
            return findK(nums, k, i + 2, r);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
// @lc code=end
