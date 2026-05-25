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
    public List<Integer> rightSideView(TreeNode root) {
        // create the output
        List<Integer> output = new ArrayList<>();

        if (root == null) {
            return output;
        }

        // create the queue
        Queue<TreeNode> queue = new LinkedList<>();

        // add the root to the queue
        queue.add(root);

        // while statement
        while(!queue.isEmpty()) {
            // get the size of the queue
            int size = queue.size();

            // iterate over the size
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (i == size-1) {
                    output.add(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return output;
    }
}
