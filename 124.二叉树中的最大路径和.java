/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    int maxVal = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxVal;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int lv = dfs(root.left);
        int rv = dfs(root.right);

        // 左右两个都不选
        int v = root.val;

        // 选择根和左边
        int v1 = v + lv;

        // 选择根和右边
        int v2 = v + rv;

        // 都选上
        int v3 = v + lv + rv;

        maxVal = Math.max(Math.max(Math.max(Math.max(v1, v2), v3), maxVal), v);
        // return只能选择单路径或者都不选，但是算max可以加上根节点
        return Math.max(Math.max(v1, v2), v);
    }
}
// @lc code=end
