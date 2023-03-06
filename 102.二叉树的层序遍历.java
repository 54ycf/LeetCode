import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    /*
     * BFS的核心是维护一个队列
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Queue<TreeNode> youngQueue = new ArrayDeque<>();
            // 此处也不必要一个新队列，可以用老队列offer进元素，然后内层循环就用for queue.size 就好

            List<Integer> line = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                line.add(node.val);
                TreeNode l = node.left, r = node.right;
                if (l != null) {
                    youngQueue.offer(l);
                }
                if (r != null) {
                    youngQueue.offer(r);
                }
            }
            res.add(line);
            queue = youngQueue;
        }
        return res;

    }
}
// @lc code=end
