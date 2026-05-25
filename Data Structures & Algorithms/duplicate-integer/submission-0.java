class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();

        for (int num: nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
