import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hMap = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if(hMap.containsKey(target-n)){
                return new int[]{hMap.get(target-n), i};
            }
            hMap.put(n, i);
        }
        return new int[0];
    }
}
// @lc code=end

