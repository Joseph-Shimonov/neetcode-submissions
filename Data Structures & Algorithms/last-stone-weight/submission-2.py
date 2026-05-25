class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        stones = [-x for x in stones]
        heapq.heapify(stones)

        # at this point, the largest values are at the top of the heap
        while len(stones) > 1:
            first = heapq.heappop(stones)
            second = heapq.heappop(stones)

            if first != second:
                heapq.heappush(stones, first - second)
        
        heapq.heappush(stones, 0)
        return abs(stones[0])
