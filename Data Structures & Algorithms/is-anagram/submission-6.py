class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if not s or not t or len(s) != len(t):
            return False
        
        freqs = [0] * 26
        for i in range(len(s)):
            freqs[ord('a') - ord(s[i])] +=1
            freqs[ord('a') - ord(t[i])] -=1

        for freq in freqs:
            if freq != 0:
                return False
        return True