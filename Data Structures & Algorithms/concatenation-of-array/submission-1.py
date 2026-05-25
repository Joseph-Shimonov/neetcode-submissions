class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        output = [0] * (len(nums) * 2)
        for i, num in enumerate(nums):
            output[i] = output[i + len(nums)] = num
        return output