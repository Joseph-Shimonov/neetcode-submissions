class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        output = []

        def dfs(curr):
            if len(curr) == len(nums):
                output.append(curr.copy())
                return
            
            for num in nums:
                if num not in curr:
                    curr.append(num)
                    dfs(curr)
                    curr.pop()
                
        dfs([])
        return output