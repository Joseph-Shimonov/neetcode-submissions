class Solution:
    def maxArea(self, heights: List[int]) -> int:
        if not heights or len(heights) == 1:
            return 0
        
        max_container = 0
        l, r = 0, len(heights)-1

        while l < r:
            curr_container = (r - l) * min(heights[r], heights[l])
            max_container = max(curr_container, max_container)

            if heights[r] < heights[l]:
                r -= 1
            else:
                l += 1
        return max_container
