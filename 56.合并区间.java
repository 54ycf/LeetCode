import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] first, int[] second){
                return first[0]-second[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        for(int i=0;i<n;++i){
            int start=intervals[i][0],end=intervals[i][1];
            int j=i+1;
            while(j<n){
                if(intervals[j][0]<=end){
                    end = intervals[j][1]>end?intervals[j][1]:end;
                    ++j;
                }else{
                    break;
                }
            }
            i = j-1;
            result.add(new int[]{start,end});
        }
        return result.toArray(new int[result.size()][]);
    }
}
// @lc code=end

