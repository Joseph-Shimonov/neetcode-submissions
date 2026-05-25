# [1, 2, 2, 3, 3, 3, 3] k=2
# count = {1: 1, 2: 2, 3: 4}
# freq = [[], [1], [2], [4], [], [], []]
from collections import defaultdict

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqs = [[] for i in range(len(nums)+1)]
        count = defaultdict(int)

        for num in nums:
            count[num] += 1
        
        for num, cnt in count.items():
            freqs[cnt].append(num)
        
        output = []
        for i in range(len(freqs)-1, 0, -1):
            for num in freqs[i]:
                output.append(num)
                if len(output) == k:
                    return output
        return output 