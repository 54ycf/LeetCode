import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 */

// @lc code=start
class Solution {
    int[][] isConnected;
    int n;
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        this.isConnected = isConnected;
        this.n = isConnected.length; //the number of cites
        this.visited = new boolean[n];
        int result = 0; //number of provinces
        for(int i=0; i<n; ++i){
            if(!visited[i]){
                dfs(i);
                ++result;
            }
        }
        return result;
    }

    public void dfs(int curCity){
        int[] line = isConnected[curCity];
        for(int i=0; i<n; ++i){
            if(!visited[i] && line[i]==1){
                visited[i] = true;
                dfs(i);
            }
        }
    }
    
}
// @lc code=end

