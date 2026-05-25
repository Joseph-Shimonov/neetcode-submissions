class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        output = defaultdict(list)
        for s in strs:
            s_sorted = ''.join(sorted(s))
            output[s_sorted].append(s)
        return list(output.values())