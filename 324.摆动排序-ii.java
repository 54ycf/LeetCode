import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=324 lang=java
 *
 * [324] 摆动排序 II
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int n = nums.length;
        int leftP = (n-1)/2, rightP = n-1;
        for(int i=0; i<n; ++i){
            if(i%2 == 0){
                nums[i] = clone[leftP--];
            }else{
                nums[i] = clone[rightP--];
            }
        }
    } 
}
// @lc code=end

