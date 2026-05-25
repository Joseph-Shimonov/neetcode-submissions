class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        self.output = []
        self.backtrack([], nums, [False] * len(nums))
        return self.output
    
    def backtrack(self, curr, nums, picked):
        if len(curr) == len(nums):
            self.output.append(curr[:])
            return
        
        for i in range(len(nums)):
            if not picked[i]:
                curr.append(nums[i])
                picked[i] = True
                self.backtrack(curr, nums, picked)
                curr.pop()
                picked[i] = False