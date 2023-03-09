import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1376 lang=java
 *
 * [1376] 通知所有员工所需的时间
 */

// @lc code=start
class Solution {
    int[] map; // 时间映射，到达员工i需要花费的时间，从hashMap升级到数组，更快的访达
    int maxTime = 0;
    int[] informTime;

    /*
     * 递归，然后记录自己的领导的时间加上领导传播给你的时间就是你的时间，维护最大值
     */
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.informTime = informTime;
        map = new int[n];
        for (int i = 0; i < n; i++) {
            rec(manager, i);
        }
        return maxTime;
    }

    private void rec(int[] manager, int staff) {
        int leader = manager[staff];
        if (leader == -1) {
            int time = informTime[staff];
            map[staff] = time;
            maxTime = maxTime > time ? maxTime : time;
            return; // 根在第零层
        }
        if (map[leader] != 0) { // 这一步是剪枝，更快，否则要一千多毫秒
            int time = map[leader] + informTime[staff];
            map[staff] = time;
            maxTime = maxTime > time ? maxTime : time;
            return;
        }
        rec(manager, leader); // 递归，到达领导的时间加上领导传播给你的时间
        int time = map[leader] + informTime[staff];
        map[staff] = time;
        maxTime = maxTime > time ? maxTime : time;
    }
}
// @lc code=end
