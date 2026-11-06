class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<ArrayList<Integer>> triplets = new HashSet<>();
        for (int i = 0; i < n; i += 1) {
            Set<Integer> currentSet = new HashSet<>();
            for (int j = i + 1; j < n; j += 1) {
                int ans = nums[i] + nums[j];
                if (currentSet.contains(-ans)){
                    ArrayList<Integer> arr = new ArrayList(List.of(nums[i], nums[j], -ans));
                    arr.sort(null);
                    triplets.add(arr);
                }
                currentSet.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> current: triplets) {
            ans.add(current);
        }
        return ans;
    }
}
