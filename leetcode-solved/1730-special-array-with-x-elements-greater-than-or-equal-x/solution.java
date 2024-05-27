class Solution {
  public int specialArray(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int x = len - i;
            if (nums[i] >= x) {
              if(i-1>=0 && nums[i-1] >= x)
                return -1;
              return x;
            }
        }
        return -1;
    }
}
