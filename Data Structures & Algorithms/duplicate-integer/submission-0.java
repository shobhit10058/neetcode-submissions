class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i += 1) {
            if (s.contains(nums[i])) {
                return true;
            }
            s.add(nums[i]);
        }
        return false;
    }
}
