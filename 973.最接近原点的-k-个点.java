import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=973 lang=java
 *
 * [973] 最接近原点的 K 个点
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //max heap
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>( (arr1,arr2) -> arr2[0]-arr1[0] ); 
        for(int i=0; i<k; ++i){ //init heap by size k of heap
            int d = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            heap.offer(new int[]{d,i}); //distance and pointer
        }
        int n = points.length;
        for(int i=k; i<n; ++i){
            int d = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            if(heap.peek()[0] > d){ //always be the min k
                heap.poll();
                heap.offer(new int[]{d,i});
            }
        }
        int[][] res = new int[k][2];
        int i=0;
        for(int[] item : heap){
            res[i++] = points[item[1]];
        }
        return res;
    }
}
// @lc code=end

