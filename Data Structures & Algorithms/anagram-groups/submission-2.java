class Solution {
    class Key {
        private final int[] freqs = new int[26];
        public Key(String str) {
            for (char c: str.toCharArray()) {
                freqs[c - 'a']++;
            }
        }
        @Override
        public int hashCode() {
            return Arrays.hashCode(freqs);
        }
        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Key)) return false;
            return Arrays.equals(this.freqs, ((Key)o).freqs);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Key, List<String>> map = new HashMap<>();
        for (String str: strs) {
            Key key = new Key(str);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
