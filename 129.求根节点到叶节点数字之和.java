import java.util.ArrayList;
import java.util.List;


/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根节点到叶节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //轻轻松松
    int res = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    void dfs(TreeNode root, int num){
        int v = num*10+root.val;
        if(root.left==null && root.right==null){
            res += v;
            return;
        }
        if(root.left!=null)
            dfs(root.left, v);
        if(root.right!=null)
            dfs(root.right, v);
    }
}
// @lc code=end

