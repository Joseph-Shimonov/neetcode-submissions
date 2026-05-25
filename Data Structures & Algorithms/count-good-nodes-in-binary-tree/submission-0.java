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
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root, root.val);
    }
    public int dfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        int res = (root.val >= max) ? 1 : 0;
        max = Math.max(max, root.val);

        res = res + dfs(root.left, max) + dfs(root.right, max);
        return res;
    }
}
