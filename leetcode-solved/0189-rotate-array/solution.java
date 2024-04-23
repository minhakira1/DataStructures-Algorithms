class Solution {
   public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0 || nums.length == k)
            return;
        int[] arrTemp = new int[k];
        int idx = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            arrTemp[idx] = nums[i];
            idx++;
        }
        for (int i = nums.length - k - 1; i >= 0 ; i--) {
            nums[i + k] = nums[i];
        }
         for (int i = 0; i < arrTemp.length ; i++) {
            nums[i] = arrTemp[i];
        }
    }
 
}
