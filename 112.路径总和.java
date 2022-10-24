import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    private int targetSum;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        if(root==null) return false;
        return solve(root, 0);
    }

    boolean solve(TreeNode node,int sum){
        if(node.left == null && node.right==null){
            if(sum+node.val == targetSum) return true;
            return false;
        }
        boolean flag1 = false, flag2 = false;
        if(node.left != null) flag1 = solve(node.left, sum+node.val);
        if(node.right != null) flag2 = solve(node.right, sum+node.val);
        return  flag1||flag2; 
    }
}
// @lc code=end

