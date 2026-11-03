class Solution {
    List<Integer> countArray(String str) {
		// list of 26 elements, each element is the count of the corresponding character
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < 26; i += 1) {
			l.add(0);
		}
        for (int i = 0 ; i < str.length(); i += 1) {
            int currChar = str.charAt(i) - 'a';
            l.set(currChar, l.get(currChar) + 1);
        }
        return l;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String> > mp = new HashMap<>();
        int lenStrs = strs.length;
        for (int i = 0; i < lenStrs; i += 1) {
            List<Integer> currCountArray = countArray(strs[i]);
            if (mp.containsKey(currCountArray)) {
                mp.get(currCountArray).add(strs[i]);
            } else {
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                mp.put(currCountArray, l);
            }
        }
        List<List<String> > anagramsList = new ArrayList<>();
        for (Map.Entry<List<Integer>, List<String> > entry: mp.entrySet()) {
            anagramsList.add(entry.getValue());
        }
        return anagramsList;
    }
}
