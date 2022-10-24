import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    public List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, root.val + "");
        return result;
    }
    public void dfs(TreeNode root, String fatherPath){
        if(root.left == null && root.right == null){
            result.add(fatherPath);
            return;
        }
        if(root.left != null){
            dfs(root.left, fatherPath + "->" + root.left.val);
        }
        if(root.right != null){
            dfs(root.right, fatherPath + "->" + root.right.val);
        }
    }
}
// @lc code=end

