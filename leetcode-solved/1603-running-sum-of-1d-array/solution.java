class Solution {
    public int[] runningSum(int[] nums) {
        int ans[] = new int[nums.length];
        int currentSum = nums[0];
        for(int i=0;i<nums.length;i++){
            ans[i] = currentSum;
            if(i+1<nums.length)
            currentSum+=nums[i+1];
        }
        return ans;
    }
}
