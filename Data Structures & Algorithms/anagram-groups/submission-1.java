class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // since we need to group the anagrams together, we should use a dictionary
        Map<Integer, List<String>> map = new HashMap<>();

        // edge case
        if (strs == null) {
            return new ArrayList<>(map.values());
        }

        // iterate over the strs
        for (String str: strs) {
            // create a freq array
            int[] count = new int[26];

            // iterate over the str
            for (char c: str.toCharArray()) {
                count[c - 'a']++;
            }

            // check if the hashcode exists in the map
            if (!map.containsKey(Arrays.hashCode(count))) {
                map.put(Arrays.hashCode(count), new ArrayList<>());
            }

            // add to the list
            map.get(Arrays.hashCode(count)).add(str);

        }

        // return
        return new ArrayList<>(map.values());        
    }
}
