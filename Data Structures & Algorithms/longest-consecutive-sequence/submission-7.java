class Solution {
    public int longestConsecutive(int[] nums) {
        // dp[x] -> dp[x  + 1] + 1
        Map<Integer, Integer> dp = new HashMap<>();
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i += 1) {
            int x = nums[i];
            Stack<Integer> values = new Stack<>();
            int currAns = 0;
            if (dp.containsKey(x)) {
                continue;
            }
            while (numSet.contains(x) && !dp.containsKey(x)) {
                values.add(x);
                x = x + 1;
            }
            while (values.size() > 0) {
                x = values.peek();
                currAns = dp.getOrDefault(x + 1, 0) + 1;
                dp.put(x, currAns);
                values.pop();
            }
            ans = Math.max(ans, currAns);
        }
        return ans;
    }
}
