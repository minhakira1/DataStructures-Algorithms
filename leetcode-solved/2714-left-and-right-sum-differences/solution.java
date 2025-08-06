class Solution {
    public int[] leftRightDifference(int[] nums) {
        int sumAll = 0;
        for (int num : nums) {
            sumAll += num;
        }
        int sumLeftCurrent = 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sumRightCurrent = sumAll - sumLeftCurrent - nums[i];
            res[i] = Math.abs(sumLeftCurrent - sumRightCurrent);
            sumLeftCurrent += nums[i];
        }
        return res;
    }
}
