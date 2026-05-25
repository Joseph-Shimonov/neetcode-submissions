class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t or len(s) < len(t):
            return ""
        
        window, count_t = {}, {}
        for c in t:
            count_t[c] = 1 + count_t.get(c, 0)
        
        output, output_len = [-1, -1], float("inf")
        have, need = 0, len(count_t)
        l = 0

        for r in range(len(s)):
            c = s[r]
            window[c] = 1 + window.get(c, 0)

            if c in count_t and window[c] == count_t[c]:
                have += 1
            
            while have == need:
                if r - l + 1 < output_len:
                    output_len = r-l+1
                    output = [l, r]
                
                window[s[l]] -= 1
                if s[l] in count_t and window[s[l]] < count_t[s[l]]:
                    have -= 1
                l +=1

        l, r = output
        return s[l:r+1] if output_len != float('inf') else ""