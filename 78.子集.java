import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    //每次拿出来，添加一个，放回去
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int len = res.size();
            int cur = nums[i];
            for (int j = 0; j < len; j++) {
                res.add(new ArrayList<>(res.get(j)) {
                    {
                        add(cur);
                    }
                });
            }
        }
        return res;
    }
}
// @lc code=end
