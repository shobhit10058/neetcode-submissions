class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> freqs = new HashMap<>();
        final Map<Integer, Set<Integer>> freqToNums = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i += 1) {
            int freq = 0;
            if (freqs.containsKey(nums[i])) {
                freq = freqs.get(nums[i]);
                freqToNums.get(freq).remove(nums[i]);
            }
            freq += 1;
            freqs.put(nums[i], freq);
            if (!freqToNums.containsKey(freq)) {
                freqToNums.put(freq, new HashSet<>());
            }
            freqToNums.get(freq).add(nums[i]);
        }

        int[] ans = new int[k];
        for (int f = n; f >= 1; f -= 1) {
            if (k == 0) {
                break;
            }
            if (freqToNums.containsKey(f)) {
                for (int num: freqToNums.get(f)) {
                    if (k == 0) {
                        break;
                    }
                    k --;
                    ans[k] = num;
                }
            }
        }
        return ans;
    }
}
