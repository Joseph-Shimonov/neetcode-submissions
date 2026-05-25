class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return null;
        }

        // create the output
        int[] output = new int[nums.length];

        // define left
        int left = 1;

        // iterate over nums
        for (int i = 0; i < nums.length; i++) {
            // nothing is to the left of the first value, so it should be defined first
            output[i] = left;

            // produce left product
            left *= nums[i];
        }

        int right = 1;

        // iterate backwards to produce right product
        for (int i = nums.length-1; i >= 0; i--) {
            // nothing to the right of the last element, so it shouldn't be changed
            output[i] *= right;
            right *= nums[i];
        }

        return output;


    }
}  
