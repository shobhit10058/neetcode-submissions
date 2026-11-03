class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i += 1) {
            if (mp.containsKey(target - nums[i])) {
                int[] ans = new int[2];
                ans[0] = mp.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            mp.put(nums[i], i);
        }
        return new int[2];
    }
}
