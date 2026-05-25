class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        // define the indices
        int left = 0;
        int right = height.length-1;

        // define the left and right maxs
        int leftMax = height[left];
        int rightMax = height[right];

        // define the output
        int output = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                output += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                output += rightMax - height[right];
            }
        }
        return output;

    }
}
