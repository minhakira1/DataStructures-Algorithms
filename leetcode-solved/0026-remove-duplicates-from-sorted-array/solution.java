class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int rightIndex = 0;
        for (int index =1;index<nums.length;index++){
            if(nums[index] != nums[rightIndex]){
                rightIndex++;
                nums[rightIndex] = nums[index];
            }
        }
        return rightIndex+1;
    }
}
