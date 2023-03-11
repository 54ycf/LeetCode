import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {

    /*
     * 对于回溯类型的题依旧把握不够，
     * 这道题的关键在于捋清楚每一步到底在干嘛，dfs函数的cur代表递归深度，
     * 当深度达到数组长度时返回，然后每一次递归循环判断这个元素是否已经在list，即已经用过了，
     * 如果不在，才进一步操作。此时在第cur层，有cur个元素，当前遍历到的元素不在list中，
     * 先将元素加进去list，继续递归cur+1层，完毕之后取出这个元素，把在for循环的下一个不在list的
     * 元素加进去，继续尝试所有可能性
     * 
     * 有个问题在于list.remove，如果是nums[i]的话，会被认为remove int，即按照下标删除，
     * 需要用list.remove(list.size()-1);或者list.remove(Integer.valueOf(nums[i]));，这里被封装成了对象
     */

    int n;
    int[] nums;
    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        this.nums = nums;
        ans = new ArrayList<>();
        dfs(0, new ArrayList<>());
        return ans;
    }

    private void dfs(int cur, List<Integer> list) {
        if(cur == n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                dfs(cur+1, list);
                // list.remove(list.size()-1);
                list.remove(Integer.valueOf(nums[i]));
            }
        }        

    }
}
// @lc code=end
