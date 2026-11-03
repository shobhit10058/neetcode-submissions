class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Set<Integer> > countToNums = new HashMap<>();
        Map<Integer, Integer> numsToCount = new HashMap<>();
        for (int i = 0; i < nums.length; i += 1) {
            int curr_c = 1;
            if (numsToCount.containsKey(nums[i])) {
                int last_c = numsToCount.get(nums[i]);
                countToNums.get(last_c).remove(nums[i]);
                if (countToNums.get(last_c).isEmpty()) {
                    countToNums.remove(last_c);
                }
                curr_c = last_c + 1;
            }

            numsToCount.put(nums[i], curr_c);
            if (!countToNums.containsKey(curr_c)) {
                countToNums.put(curr_c, new HashSet<Integer>());
            }
            countToNums.get(curr_c).add(nums[i]);
        }
        int[] ans = new int[k];
        for (int i = nums.length; i > 0; ) {
            if (k == 0) {
                break;
            }
            if (!countToNums.containsKey(i)) {
                i --;
                continue;
            }
            ans[k - 1] = countToNums.get(i).iterator().next();
            countToNums.get(i).remove(ans[k - 1]);
            if (countToNums.get(i).isEmpty()) {
                countToNums.remove(i);
            }
            k --;
        }
        return ans;
    }
}
