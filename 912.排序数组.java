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
    // 法3，堆排序
    public int[] sortArray(int[] nums) {
        // quickSort(nums, 0, nums.length - 1);
        // mergeSort(nums, 0, nums.length - 1);
        heapSort(nums);
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

    private void heapSort(int[] nums) {
        buildHeap(nums);
        for (int i = nums.length - 1; i > 0; --i) {
            swap(nums, i, 0);
            heapify(nums, 0, i);
        }
    }

    private void buildHeap(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; --i) {
            heapify(nums, i, len);
        }
    }

    /**
     * @param nums
     * @param i    当前维护的下标
     * @param len  数组长度
     */
    private void heapify(int[] nums, int i, int len) {
        int leftSonInd = i * 2 + 1;
        int rightSonInd = i * 2 + 2;
        int largestInd = i;
        if (leftSonInd < len && nums[leftSonInd] > nums[largestInd]) {
            largestInd = leftSonInd;
        }
        if (rightSonInd < len && nums[rightSonInd] > nums[largestInd]) {
            largestInd = rightSonInd;
        }
        if (i != largestInd) {
            swap(nums, i, largestInd);
            heapify(nums, largestInd, len);
        }
    }
}
// @lc code=end
