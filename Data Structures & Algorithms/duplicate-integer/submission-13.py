class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        l = len(nums)
        s = len(set(nums))
        if s < l:
            return True
        else:
            return False