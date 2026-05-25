class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        output = defaultdict(list)

        for s in strs:
            freqs = [0] * 26
            for c in s:
                freqs[ord(c) - ord('a')] += 1 
            output[tuple(freqs)].append(s)
        return list(output.values())