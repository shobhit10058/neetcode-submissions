class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // suffixproduct = product of nums[i]*nums[i+1]...
        int[] suffixProducts = new int[n + 1];
        suffixProducts[n] = 1;
        for (int i = 0; i < n; i += 1) {
            suffixProducts[n - i - 1] = suffixProducts[n - i] * nums[n - i - 1];
        }   
        int[] ans = new int[n];
        int runningPrefProduct = 1; // does not include current element
        for (int i = 0; i < n; i += 1) {
            ans[i] = runningPrefProduct * suffixProducts[i + 1];
            runningPrefProduct *= nums[i];
        }
        return ans;
    }
}  
