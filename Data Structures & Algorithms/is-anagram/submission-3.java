class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        int[] freqs = new int[26];

        for (int i = 0; i < sarr.length; i++) {
            freqs[sarr[i] - 'a']++;
            freqs[tarr[i] - 'a']--;
        }

        for (int freq: freqs) {
            if (freq != 0) {
                return false;
            }
        }
        return true;
    }
}
