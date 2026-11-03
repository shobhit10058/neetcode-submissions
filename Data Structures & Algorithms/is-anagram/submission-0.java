class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count_c = new int[26];
        for (int i = 0; i < s.length(); i += 1) {
            char c = s.charAt(i);
            count_c[c - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i += 1) {
            char c = t.charAt(i);
            count_c[c - 'a'] -= 1;
        }
        for (int i = 0; i < 26; i += 1) {
            if (count_c[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
