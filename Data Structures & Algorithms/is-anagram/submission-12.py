class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if not s or not t or len(s) != len(t):
            return False
        
        freqs = [0] * 26
        for i in range(len(s)):
            schar = ord('a') - ord(s[i])
            tchar = ord('a') - ord(t[i])

            freqs[schar] += 1
            freqs[tchar] -= 1
        
        return all(freq == 0 for freq in freqs)
