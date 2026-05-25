class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return null;
        }   
        
        // create the output
        int[] output = new int[nums.length];

        int pre = 1;
        
        // slide to the right
        for (int i = 0; i < nums.length; i++) {
            output[i] = pre;
            pre *= nums[i];
        }

        int post = 1;

        // slide to the left
        for (int i = nums.length-1; i >= 0; i--) {
            output[i] *= post;
            post *= nums[i];
        }

        return output;
    }
}  
