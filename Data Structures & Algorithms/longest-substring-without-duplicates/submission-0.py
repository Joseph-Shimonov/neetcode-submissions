class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l = 0 
        charset = set()
        longest = 0 

        for r in range(len(s)):
            while s[r] in charset:
                charset.remove(s[l])
                l +=1
            else:
                charset.add(s[r])
            longest = max(longest, r-l +1)
        return longest