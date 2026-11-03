class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer> > triplets = new ArrayList<>();
        Set<List<Integer> > tripletSet = new HashSet<>();
        for (int i = 0; i < nums.length; i += 1) {
            Map<Integer, Integer> mp = new HashMap<>();
            for (int k = i + 1; k < nums.length; k += 1) {
                mp.put(nums[k], k);
            }
            for (int j = i + 1; j < nums.length; j += 1) {
                if (mp.get(nums[j]) == j) {
                    mp.remove(nums[j]);
                }
                int target = nums[i] + nums[j];
                if (mp.containsKey(-target)) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(-target);
                    l.sort(null);
                    if (!tripletSet.contains(l)) {
                        tripletSet.add(l);
                        triplets.add(l);
                    }
                }
            }
        }
        return triplets;
    }
}
