class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int idx = 0; idx < nums.length; idx ++ ) {
            if (s.contains(nums[idx])) {
                return true;
            }
            s.add(nums[idx]);
        }
        return false;
    }
}