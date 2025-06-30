class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[][] valuesWithIdx = new int[nums.length][2];
          for (int i = 0; i < nums.length; i++) {
            valuesWithIdx[i] = new int[]{nums[i], i}; // Store value and its original index
        }
        //sort max values
        Arrays.sort(valuesWithIdx, (a,b) -> b[0] - a[0]);
        // This compares values (a[0] and b[0]) and sorts bigger values first

        //sort max values by original index in k length
        Arrays.sort(valuesWithIdx, 0, k, (a,b) -> a[1] - b[1]);

        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = valuesWithIdx[i][0];
        }
        return ans;
    }
}
