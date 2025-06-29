class Solution {
    public int numSubseq(int[] nums, int target) {
        final int MOD = 1_000_000_007;
        int n = nums.length;
        Arrays.sort(nums);

        // pre compute powers of 2 up to n
        int[] powers = new int[n];
        powers[0] = 1; // 2^0 = 1
        for(int i=1;i<n;i++){
            powers[i] = (powers[i-1]*2) % MOD;
        }

        int left = 0, right = n-1;
        int ans = 0;
        while(left <= right){
            if(nums[left] + nums[right] <= target){
                ans = (ans + powers[right-left])  % MOD;
                left++;
            } else{
                right--;
            }
        }
        return ans;
    }
}
