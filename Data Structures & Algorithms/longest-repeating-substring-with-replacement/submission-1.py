class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        if not s:
            return 0
        
        count = defaultdict(int)
        l = output = 0

        for r in range(len(s)):
            count[s[r]] += 1

            if (r-l+1) - max(count.values()) <= k:
                output = max(output, r-l+1)
            else:
                count[s[l]] -= 1
                l += 1
            
        return output