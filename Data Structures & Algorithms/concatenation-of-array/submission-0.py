class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        output = [0] * (len(nums) * 2)
        for i in range(len(nums)):
            output[i] = nums[i]
            output[len(nums)+i] = nums[i]
        return output