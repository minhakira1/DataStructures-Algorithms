class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        if (nums[left] == nums[n - 1])
            return 0;
        int maxLength = 0;
        for (int right = 1; right < n; right++) {
            while(nums[right] - nums[left] > 1 && right>=left){
                left++;
            }
            if (nums[right] - nums[left] == 1 ) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength;
    }
}
