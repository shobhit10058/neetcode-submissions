class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, r = n - 1;
        while (l < r) {
            if ((numbers[l] + numbers[r]) > target) {
                r --;
                continue;
            }
            if ((numbers[l] + numbers[r]) == target) {
                return new int[]{l + 1, r + 1};
            }
            l ++;
        }
        return new int[0];
    }
}
