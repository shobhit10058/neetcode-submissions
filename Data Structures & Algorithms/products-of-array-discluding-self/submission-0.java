class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] backProducts = new int[length + 1];
        backProducts[length] = 1;
        for (int i = length - 1; i >= 0; i -= 1) {
            backProducts[i] = backProducts[i + 1] * nums[i];
        }
        int currentFrontProduct = 1;
        int[] values = new int[length];
        for (int i = 0; i < length; i += 1) {
            values[i] = currentFrontProduct * backProducts[i + 1];
            currentFrontProduct *= nums[i];
        }
        return values;
    }
}  
