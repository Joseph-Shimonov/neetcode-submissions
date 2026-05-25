class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        // pointers
        int left = 0;
        int right = numbers.length-1;

        // while loop
        while (left < right) {
            while (left < right && numbers[left] + numbers[right] > target) {
                right--;
            } 
            while (left < right && numbers[left] + numbers[right] < target) {
                left++;
            }
            if (left < right && numbers[left] + numbers[right] == target) {
                return new int[] {left+1, right+1};
            }
        }

        // edge result
        return new int[] {-1, -1};
    }
}
