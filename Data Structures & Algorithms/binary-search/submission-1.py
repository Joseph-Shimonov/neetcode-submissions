class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        
        l, r = 0, len(nums)-1
        while l <= r:
            mid = (l + r ) // 2
            if nums[l] == target:
                return l
            elif nums[r] == target:
                return r
            elif nums[mid] == target:
                return mid
            elif target > nums[mid]:
                l = mid+1
            else:
                r = mid-1
        return -1