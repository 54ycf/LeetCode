/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    int ml, mr, len, target;

    public int search(int[] nums, int target) {
        len = nums.length;
        ml = nums[0]; // most left
        mr = nums[len - 1];
        this.target = target;
        if (len == 1)
            return target == ml ? 0 : -1;
        int k = biSearchK(nums, 0, len - 1);
        if (nums[k] < mr) {
            --k;
        }
        if (target > ml && target < nums[k]) {
            // search 0-k
            return binarySearch(nums, target, 0, k);
        } else if (target > nums[k + 1] && target < mr) {
            // search k+1 - len-1
            return binarySearch(nums, target, k + 1, len - 1);
        }
        return -1;
    }

    private int biSearchK(int[] nums, int l, int r) {
        int mid = l + (r - l) / 2;
        int midVal = nums[mid];
        if (l == r)
            return l;
        else if (midVal > ml) {
            return biSearchK(nums, mid + 1, r);
        } else if (midVal < mr) {
            return biSearchK(nums, l, mid - 1);
        } else {
            return -1;
        }
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

    private static int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, right);
        } else {
            return binarySearch(nums, target, left, mid - 1);
        }
    }

}
// @lc code=end
