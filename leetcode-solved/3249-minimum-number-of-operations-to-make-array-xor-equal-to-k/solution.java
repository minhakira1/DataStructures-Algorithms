class Solution {
    public int minOperations(int[] nums, int k) {
        int finalNumXOR = nums[0];
        for (int i = 1; i < nums.length; i++) {
          finalNumXOR = finalNumXOR ^ nums[i];
        }
        return Integer.bitCount(finalNumXOR ^ k);
    }
}
