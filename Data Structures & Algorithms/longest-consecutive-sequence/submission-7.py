class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
    
        s = set(nums)
        output = 0
        for num in s:
            if num-1 in s:
                continue
            
            count = 1
            curr = num
            while curr+1 in s:
                count+=1
                curr+=1

            output = max(output, count)
        return output