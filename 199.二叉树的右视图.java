import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;


/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
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
     * 不难，就是bfs每次记录最后一个，但是感觉写的不够优雅
     * 
     * 有一种做法不用每次new一个新的level，而是用for循环记录每层遍历到了第几个，到末尾就添加记录
     * 还有一种dfs做法，dfs参数里有一个表示深度的，然后每次dfs根-右-左，每个每层都是最先访问最右边的节点的
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        res.add(root.val);
        while (true) {
            Deque<TreeNode> level = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null)
                    level.offer(left);
                if (right != null)
                    level.offer(right);
            }
            if (level.isEmpty())
                break;
            res.add(level.peekLast().val);
            queue = level;
        }
        return res;
    }

}
// @lc code=end
