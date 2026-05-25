class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        output = defaultdict(list)

        for st in strs:
            chars = [0] * 26
            for s in st:
                chars[ord(s) - ord('a')] += 1
            output[tuple(chars)].append(st)
        
        return list(output.values())