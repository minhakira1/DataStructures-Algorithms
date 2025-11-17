class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int current1 = -9999;
        for(int i=0;i < nums.length; i++){
            if(nums[i] == 1){
                if(current1 < 0){
                    current1 = i;
                } else if(current1 + k >= i){
                    return false;
                } else {
                    current1 = i;
                }
            }
        }
        return true;
    }
}
