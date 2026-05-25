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

    /*
        for this question, we can use BFS since we are adding nodes based on LEVEL
    */

    public int maxDepth(TreeNode root) {
        int level = 0;

        if (root == null) {
            return level;
        }  

        // create the queue
        Queue<TreeNode> queue = new LinkedList<>();

        // add the root to the queue
        queue.offer(root);

        // create a size var
        int size;

        // iterate thru the queue
        while(!queue.isEmpty()) {
            // at this point all of the children from the current level have been added to the queue
            level++;
            
            // get the size of the queue -> this is everything in its level
            size = queue.size();

            while(size != 0) {
                TreeNode temp = queue.poll();

                // add its left and right children
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                size--;
            }
        } 
        return level;


    }
}
