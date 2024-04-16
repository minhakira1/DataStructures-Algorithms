import java.util.Arrays;

public class MinimumSumSubarrays {
  public int minSumOfLengths(int[] nums, int[] andValues) {
    int n = nums.length;
    int m = andValues.length;

    // dp[i] stores the minimum sum of lengths of subarrays ending at index i with given AND value
    int[] dp = new int[n];
    Arrays.fill(dp, Integer.MAX_VALUE);

    int result = Integer.MAX_VALUE;
    int minLen = Integer.MAX_VALUE;
    int j = 0;
    int currAnd = 0;

    for (int i = 0; i < n; i++) {
      currAnd &= nums[i];

      while (j <= i && currAnd != andValues[0]) {
        currAnd &= nums[j];
        j++;
      }

      if (currAnd == andValues[0]) {
        if (j > 0 && dp[j - 1] != Integer.MAX_VALUE) {
          minLen = Math.min(minLen, i - j + 1 + dp[j - 1]);
        }
      }

      dp[i] = minLen;

      if (i >= m - 1) {
        result = Math.min(result, dp[i]);
        currAnd ^= nums[i - m + 1];
        minLen = (i - m >= 0) ? dp[i - m] : Integer.MAX_VALUE;
      }
    }

    return result == Integer.MAX_VALUE ? -1 : result;
  }

  public static void main(String[] args) {
    MinimumSumSubarrays solution = new MinimumSumSubarrays();

    int[] nums1 = {1, 4, 3, 3, 2};
    int[] andValues1 = {0, 3, 3, 2};
    System.out.println(solution.minSumOfLengths(nums1, andValues1)); // Output: 12

    int[] nums2 = {2, 3, 5, 7, 7, 7, 5};
    int[] andValues2 = {0, 7, 5};
    System.out.println(solution.minSumOfLengths(nums2, andValues2)); // Output: 17

    int[] nums3 = {1, 2, 3, 4};
    int[] andValues3 = {2};
    System.out.println(solution.minSumOfLengths(nums3, andValues3)); // Output: -1
  }
}
