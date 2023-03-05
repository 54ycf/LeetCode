/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    /*
     * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
     * 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
     */

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midVal = nums[mid];
            int leftVal = nums[left], rightVal = nums[right];
            if (midVal == target) {
                return mid;
            } else if (midVal >= leftVal) {
                if (target < midVal && target >= leftVal)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (target > midVal && target <= rightVal)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    // public static int binarySearch(int[] nums, int target) {
    // int left = 0, right = nums.length - 1;
    // while (left <= right) {
    // int mid = left + (right - left) / 2;
    // if (nums[mid] == target) {
    // return mid;
    // } else if (nums[mid] < target) {
    // left = mid + 1;
    // } else {
    // right = mid - 1;
    // }
    // }
    // return -1;
    // }

    // private static int binarySearch(int[] nums, int target, int left, int right)
    // {
    // if (left > right) {
    // return -1;
    // }
    // int mid = left + (right - left) / 2;
    // if (nums[mid] == target) {
    // return mid;
    // } else if (nums[mid] < target) {
    // return binarySearch(nums, target, mid + 1, right);
    // } else {
    // return binarySearch(nums, target, left, mid - 1);
    // }
    // }

}
// @lc code=end
