class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n*2];
        int index =0;
        for(int i=0;i<n;i++){
            ans[index] = nums[i];
            index++;
            ans[index] = nums[i+n];
            index++;
        }
        return ans;
    }
}
