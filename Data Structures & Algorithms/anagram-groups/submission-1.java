class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // map of array of 26 size, list of strings
        Map<ArrayList<Integer>, ArrayList<String>> mp = new HashMap<>();
        for (int idx = 0; idx < strs.length; idx += 1) {
            int[] arr = new int[26];
            Arrays.fill(arr, 0);
            String s = strs[idx];
            for (int sIdx = 0; sIdx < s.length(); sIdx += 1) {
                arr[s.charAt(sIdx)-'a'] += 1;
            }
            ArrayList<Integer> arrayList = new ArrayList<>(26);
            for (int x: arr) {
                arrayList.add(x);
            }
            mp.compute(arrayList, (k, v) -> {
                if (v == null) {
                    ArrayList<String> vArr = new ArrayList<>();
                    vArr.add(s);
                    return vArr;
                }
                v.add(s);
                return v;
            });
        }
        return new ArrayList<>(mp.values());
    }
}
