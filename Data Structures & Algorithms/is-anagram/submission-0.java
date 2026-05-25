class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int[] freqs = new int[26];

        for (int i = 0; i < sArr.length; i++) {
            freqs[sArr[i] - 'a']++;
            freqs[tArr[i] - 'a']--;
        }

        for (int freq: freqs) {
            if (freq != 0) {
                return false;
            }
        }
        return true;
    }
}
