class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // output
        List<List<Integer>> list = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return list;
        }

        // sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;          // we break because all of the values after will only be greater
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;       // we will reach the same result as the prev iteration
            }

            int left = i+1;
            int right = nums.length - 1;

            while (left < right) {
                // decrement right
                while (left < right && nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                }

                // incement left
                while (left < right && nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                }

                if (left < right && nums[left] + nums[right] + nums[i] == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                }
            }
        }
        return list;
    }
}
