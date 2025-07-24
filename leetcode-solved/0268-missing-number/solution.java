class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumFull = (0+n) *(n+1) /2;
        int sumNums = 0;
        for(int i=0;i<n;i++){
            sumNums+=nums[i];
        }
        return sumFull - sumNums;      
    }
}
