class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();

        for (String str: strs) {
            int[] freqs = new int[26];
            for (char c: str.toCharArray()) {
                freqs[c - 'a']++;
            }
            map.computeIfAbsent(Arrays.hashCode(freqs), k -> new ArrayList()).add(str);
        }
        return new ArrayList(map.values());
    }
}
