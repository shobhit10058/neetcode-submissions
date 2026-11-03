class Solution {
    Map<Character, Integer> computeFrequencyMap(String s) {
        Map<Character, Integer> freqOfChars = new HashMap<>();
        for (int idx = 0; idx < s.length(); idx ++) {
            Character c = s.charAt(idx);
            freqOfChars.compute(c, (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return v + 1;
            });
        }
        return freqOfChars;
    }
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sFreqMap, tFreqMap;
        sFreqMap = computeFrequencyMap(s);
        tFreqMap = computeFrequencyMap(t);
        if (sFreqMap.size() != tFreqMap.size()) {
            return false;
        } 
        for (Character c: sFreqMap.keySet()) {
            if (!sFreqMap.get(c).equals(tFreqMap.get(c)) ){
                return false;
            }
        }
        return true;
    }
}
