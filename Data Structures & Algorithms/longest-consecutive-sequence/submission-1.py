class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        mp = defaultdict(int)
        output = 0

        for num in nums:
            if not mp[num]:
                mp[num] = mp[num-1] + mp[num+1] + 1
                mp[num - mp[num-1]] = mp[num]
                mp[num + mp[num+1]] = mp[num]
                output = max(output, mp[num])
        return output