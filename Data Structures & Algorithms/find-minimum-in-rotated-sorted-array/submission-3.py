class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums:
            return -1
        
        l, r = 0, len(nums)-1
        while l < r:
            mid = (l + r) // 2
            
            if nums[mid] > nums[r]:
                l = mid+1
            else:
                r = mid
        return nums[l]