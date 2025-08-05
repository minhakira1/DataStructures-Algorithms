class Solution {
    public int maxSum(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        boolean hasPositive = false;
        int maxSum = 0;
        int maxNegative = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < 0) {
                maxNegative = Math.max(maxNegative, num);
            } else {
                hasPositive = true;
                if (set.add(num)) {
                    maxSum += num;
                }
            }
        }
        if (!hasPositive) {
            return maxNegative;
        }
        return maxSum;
    }
}
