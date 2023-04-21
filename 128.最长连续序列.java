import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    //关键是Hash表，下面其他人的方法更简单
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>(); //v是
        for (int n : nums) 
            map.put(n,1);
        Integer max = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key)!=1)
                continue;
            rec(map, key);
            max = Math.max(max, map.get(key));
        }
        return max;
    }

    void rec(Map<Integer,Integer> map, int n){
        if(map.containsKey(n+1)){
            Integer n2 = map.get(n+1);       
            if(n2!=1){
                map.put(n, map.get(n) + n2);
                return;
            } else{
                rec(map, n+1);
                map.put(n, map.get(n+1)+map.get(n));
            }     
        }
    }

    int otherMethod(int[] nums){
        Set<Integer> set = new HashSet<>();
        int ans= 0;
        for(int m : nums){
           set.add(m);
        }
        for(int m : set){
            //找到第一个结点，如果减一不存在就说明是第一个
            if(!set.contains(m-1)){
                //记录下一个即将判断的数
                int x = m +1 ;
                while(set.contains(x)) x++;
                ans = Math.max(ans , (x - m));
            }
        }
        return ans ;
    }
}
// @lc code=end

