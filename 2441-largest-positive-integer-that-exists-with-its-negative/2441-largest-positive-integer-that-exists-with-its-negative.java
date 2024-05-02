class Solution {
    public int findMaxK(int[] nums) {
      Set<Integer> setNegativeNums = new HashSet<>();
      int max = -1;
      for (int i = 0; i < nums.length; i++) {
        if (setNegativeNums.contains(-nums[i]) && max < Math.abs(nums[i])) {
          max = Math.abs(nums[i]);
        }

        setNegativeNums.add(nums[i]);
      }
      return max;
    }
}