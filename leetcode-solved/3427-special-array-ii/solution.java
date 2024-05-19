class Solution {
  public boolean[] isArraySpecial(int[] nums, int[][] queries) {
    int n = nums.length;
    int[] transitions = new int[n];
    
    // Fill the transitions array where transitions[i] is 1 if nums[i] is different parity from nums[i-1], else 0
    for (int i = 1; i < n; i++) {
      transitions[i] = (nums[i] % 2 != nums[i - 1] % 2) ? 1 : 0;
    }

    // Create a prefix sum array for the transitions
    int[] prefixSum = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      prefixSum[i] = prefixSum[i - 1] + transitions[i - 1];
    }

    boolean[] dp = new boolean[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int left = queries[i][0];
      int right = queries[i][1];
      if (left == right) {
        dp[i] = true;
      } else {
        // Check if there is any transition within the range [left, right]
        dp[i] = (prefixSum[right + 1] - prefixSum[left + 1]) == (right - left);
      }
    }
    return dp;
  }
}

