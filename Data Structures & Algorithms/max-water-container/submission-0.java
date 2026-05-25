class Solution {
    public int maxArea(int[] heights) {
        if (heights == null || heights.length < 2 ) {
            return 0;
        }

        int left = 0;
        int right = heights.length-1;

        int output = 0;

        while (left < right) {
            int leftHeight = heights[left];
            int rightHeight = heights[right];

            output = Math.max(output, (right-left)*(Math.min(leftHeight, rightHeight)));

            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }
        return output;
    }
}
