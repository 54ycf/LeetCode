import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    //单调队列，好难
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        Deque<Integer> q = new LinkedList<>();
        int[] res = new int[len];
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]){
                q.pollLast();
            }
            // 添加当前值对应的数组下标
            q.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(q.peek() <= i-k){
                q.poll();   
            } 
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                res[i+1-k] = nums[q.peek()];
            }
        }
        return res;
    }

}
// @lc code=end
