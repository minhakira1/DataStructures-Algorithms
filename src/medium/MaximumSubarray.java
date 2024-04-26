package medium;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubarray {

  /**
   * Given an integer array nums, find the
   * subarray
   * with the largest sum, and return its sum.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
   * Output: 6
   * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
   * Example 2:
   * <p>
   * Input: nums = [1]
   * Output: 1
   * Explanation: The subarray [1] has the largest sum 1.
   * Example 3:
   * <p>
   * Input: nums = [5,4,-1,7,8]
   * Output: 23
   * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
   * <p>
   * <p>
   * Constraints:
   * <p>
   * 1 <= nums.length <= 105
   * -104 <= nums[i] <= 104
   * <p>
   * <p>
   * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide
   * and conquer approach, which is more subtle.
   **/
  public int maxSubArray(int[] nums) {
    /**
     * My DP reasoning is as follows:
     *
     * To calculate sum(0,i), you have 2 choices: either adding sum(0,i-1) to a[i], or not.
     * If sum(0,i-1) is negative, adding it to a[i] will only make a smaller sum,
     * so we add only if it's non-negative.
     *
     * sum(0,i) = a[i] + (sum(0,i-1) < 0 ? 0 : sum(0,i-1))
     * We can then use O(1) space to keep track of the max sum(0, i) so far.
     *
     * public int maxSubArray(int[] nums) {
     * 	if (nums == null || nums.length == 0) { return 0; }
     * 	int max = nums[0], sum = nums[0];
     * 	for (int i = 1; i < nums.length; i++) {
     * 		if (sum < 0) { sum = nums[i]; }
     * 		else {sum += nums[i]; }
     * 		max = Math.max(max, sum);
     *    }
     * 	return max;
     * }
     * **/
    int maxVal = nums[0];
    for (int i = 0; i < nums.length; i++) {
      int sum = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        sum += nums[j];
        maxVal = Math.max(maxVal, sum);
      }
    }
    return maxVal;
  }
}
