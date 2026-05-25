class Solution:
    def maxArea(self, heights: List[int]) -> int:
        l, r = 0, len(heights)-1
        max_volume = 0
        while l < r:
            lh = heights[l]
            rh = heights[r]

            max_volume = max(max_volume, (r-l) * min(lh, rh))
            if lh < rh:
                l += 1
            else:
                r -= 1
        return max_volume