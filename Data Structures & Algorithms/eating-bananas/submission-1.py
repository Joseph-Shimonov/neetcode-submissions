class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        if not piles or len(piles) > h:
            return -1
        
        l, r = 1, max(piles)
        output = r

        while l <= r:
            mid = (l + r) // 2
            hours = 0
            for p in piles:
                hours += math.ceil(p / mid)
            
            if hours <= h:
                output = min(output, mid)
                r = mid - 1
            else:
                l = mid + 1
        return output