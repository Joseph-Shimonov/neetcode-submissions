class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        freq_matches = defaultdict(list)

        for word in strs:
            freqs = [0] * 26
            for c in word:
                freqs[ord(c) - ord('a')] += 1
            freqs_tuple = tuple(freqs)
            freq_matches[freqs_tuple].append(word)
        
        return list(freq_matches.values())

