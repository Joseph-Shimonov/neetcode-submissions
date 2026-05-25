class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num:nums) {
            set.add(num);
        }

        int output = 0;
        for (int num: set) {
            if (!set.contains(num-1)) {
                int len = 1;
                while (set.contains(num+len)) {
                    len++;
                }
                output = Math.max(output, len);

                if (output >= set.size()/2) {
                    return output;
                }
            }
        }
        return output;
    }
}
