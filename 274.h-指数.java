import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * @lc app=leetcode.cn id=274 lang=java
 *
 * [274] H 指数
 */

// @lc code=start
class Solution {
    // public int hIndex(int[] citations) {
    //     IntStream stream = Arrays.stream(citations);
    //     Stream<Integer> st = stream.boxed();
    //     Integer[] arr = st.toArray(Integer[]::new); //一些高级特性，int[]转Integer[]
    //     Arrays.sort(arr, (first,second)->{
    //         return second - first;
    //     });
    //     if(arr[0]==0)return 0;
    //     int res = 1;
    //     for(int i=0;i<arr.length;++i){
    //         if(arr[i] < res){
    //             break;
    //         }
    //         res++;
    //     }
    //     return res-1;
    // }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        if(citations[n-1]==0)return 0;
        int res = 1;
        for(int i=n-1;i>=0;--i){
            if(citations[i] < res){
                break;
            }
            res++;
        }
        return res-1;
    }
}
// @lc code=end

