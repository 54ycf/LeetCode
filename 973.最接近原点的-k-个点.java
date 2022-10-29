import java.util.PriorityQueue;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=973 lang=java
 *
 * [973] 最接近原点的 K 个点
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int[][] arr = new int[n][2]; //not necessary, if use points[][], more efficient
        for(int i=0; i<n; ++i){
            int d = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            arr[i][0] = d;
            arr[i][1] = i;
        }
        selectK(arr, k, 0, n-1);
        int[][] ans = new int[k][2];
        for(int i=0; i<k; ++i){
            ans[i] = points[arr[i][1]];
        }
        return ans;
    }

    Random random = new Random();
    void selectK(int[][] arr, int k, int l, int r){
        int pPivot = l + random.nextInt(r-l+1);
        //partition ->
        swap(arr, pPivot, r);
        int i=l, j=r-1;
        int pivotVal = arr[r][0];
        while(i-1 != j){ //beware not i!=j
            if(arr[i][0] <= pivotVal){
                ++i;
            }else{
                swap(arr, i, j);
                --j;
            }
        }
        swap(arr, i, r);
        //<- partition
        if(i == k - 1) return;
        else if(i < k - 1) selectK(arr, k, i+1, r);
        else selectK(arr, k, l, i-1);
    }

    void swap(int[][] arr, int i, int j){
        int[] tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
// @lc code=end

