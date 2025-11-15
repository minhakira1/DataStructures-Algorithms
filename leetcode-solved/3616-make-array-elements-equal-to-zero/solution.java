class Solution {
    public int countValidSelections(int[] nums) {
        int len = nums.length, count = 0, left = 0;
        int right = Arrays.stream(nums).sum();
        for(int i=0;i<len;i++){
            left += nums[i];
            right -= nums[i];
            if(nums[i] != 0)
                continue;
            if(left == right)
                count+=2; // 2 directions valid
            else if(Math.abs(left - right) == 1)
                count+=1;// only a single direction valid
        }
        return count;
    }
}
