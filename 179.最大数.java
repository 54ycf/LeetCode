import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        if(n==1)return String.valueOf(nums[0]);
        String[] sNums = new String[n];
        for(int i=0;i<n;++i){
            sNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(sNums, (first,second) -> {
            String combA = first+second;
            String combB = second+first;
            return combB.compareTo(combA);
        });
        int i = 0;
        while(i<(n-1)&&sNums[i].equals("0")){
            ++i;
        }

        String res = "";
        while(i<n){
            res = res + sNums[i];
            ++i;
        }
        return res;
    }
}
// @lc code=end

