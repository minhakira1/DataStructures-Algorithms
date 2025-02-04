class Solution {
  public int maxAscendingSum(int[] nums) {
    int maxSum = nums[0], n = nums.length;
    int sum = nums[0];
    if (n == 1)
      return nums[0];
    for (int i = 1; i < n; i++) {
      if (nums[i] > nums[i - 1]) {
        sum += nums[i];
      } else {
        sum = nums[i];
      }
      if (sum > maxSum)
        maxSum = sum;
    }
    return maxSum;
  }
}
