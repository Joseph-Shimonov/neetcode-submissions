class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        minheap = []
        for x, y in points:
            minheap.append([x**2 + y**2, x, y])
        
        heapq.heapify(minheap)
        output = []

        for i in range(k):
            point, x, y = heapq.heappop(minheap)
            output.append([x,y])
        return output