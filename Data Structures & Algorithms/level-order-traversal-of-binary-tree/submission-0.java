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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // create the output 
        List<List<Integer>> output = new ArrayList<>();

        if (root == null) {
            return output;
        }

        // create the queue
        Queue<TreeNode> queue = new LinkedList<>();

        // add the root to the queue
        queue.add(root);

        // while loop setup here
        while (!queue.isEmpty()) {

            // get the size of the current level
            int size = queue.size();

            // create a temp list where we will put all of the level contents in
            List<Integer> temp = new ArrayList<>();

            // iterate thru the size
            for (int i = 0; i < size; i++) {
                
                // pop off the first element and put it in the temp list
                TreeNode node = queue.poll();
                temp.add(node.val);

                // check if the left value is not null
                if (node.left != null) {
                    // add to the queue
                    queue.add(node.left);
                }
                // check if the right value is not null
                if (node.right != null) {
                    // add to the queue
                    queue.add(node.right);
                }
            }
            // add the temp list to the output
            output.add(temp);
        }
        // return the output
        return output;
    }
}
