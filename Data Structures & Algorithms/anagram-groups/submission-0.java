class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // since we need to group the anagrams together, we should use a dictionary
        Map<String, List<String>> output = new HashMap<>();

        if (strs == null || strs.length == 0) {
            return new ArrayList<>(output.values());
        }

        // iterate over the strings
        for (String s: strs) {
            int[] count = new int[26];

            // iterate over the string that you're at
            for (char c: s.toCharArray()) {
                count[c-'a']++;
            }

            // convert the string to an array and then add it to the output
            String key = Arrays.toString(count);
            if (!output.containsKey(key)) {
                output.put(key, new ArrayList<>());
            }

            output.get(key).add(s);
        }

        return new ArrayList<>(output.values());
    }
}
