/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
     * 他人思路：
     * 分为3种情况，1.p和q在某祖先的两侧；2.p是祖先，q是后代；3.q是祖先，p是后代
     * 在dfs遍历时，
     * 如果这个点就是某个成员，就返回这个找到的点，
     * 如果左子树找到了成员，且右子树找到了成员，就返回这个根节点
     * 如果左子树找到了，右子树没找到，就返回左子树找到的成员
     * 如果右子树找到了，左子树没找到，就返回右子树找到的成员
     * 都找不到就返回null不存在
     * 
     * 当然，给定的前提是p和 q均存在于给定的二叉树中、所有 Node.val 互不相同，这很重要
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;
        // 这两个if判断可以缩写成 if(root==null||root==p||root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null)
            return null;
        else if (left != null && right != null) {
            return root;
        } else if (left == null && right != null) {
            return right;
        } else {
            return left;
        }
    }
}
// @lc code=end
