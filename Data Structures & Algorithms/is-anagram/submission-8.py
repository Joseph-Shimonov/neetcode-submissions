class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if not s or not t or len(s) != len(t):
            return False
        
        arr = [0] * 26
        for i in range(len(s)):
            schar = ord('a') - ord(s[i])
            tchar = ord('a') - ord(t[i])

            arr[schar] += 1
            arr[tchar] -= 1
        
        return all(val == 0 for val in arr)