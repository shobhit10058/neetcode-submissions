class Solution {
    public int longestConsecutive(int[] nums) {
        int max_section_l = 0, curr_section_l = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 1) {
            if ((curr_section_l > 0) && (nums[i] == nums[i - 1] + 1 || nums[i] == nums[i - 1])) {
                curr_section_l += (nums[i] == nums[i - 1] + 1) ? 1 : 0;
            } else {    
                if (curr_section_l > max_section_l) {
                    max_section_l = curr_section_l;
                }
                curr_section_l = 1;
            }
        }
        if (curr_section_l > max_section_l) {
            max_section_l = curr_section_l;
        }
        return max_section_l;
    }
}
