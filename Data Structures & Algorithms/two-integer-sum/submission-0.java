class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> s = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i += 1) {
            if (s.containsKey(target - nums[i])) {
                return new int[]{s.get(target-nums[i]), i};
            }
            s.put(nums[i], i);
        }
        return new int[2];
    }
}