class Solution {
    public int findMaxK(int[] nums) {
      Set<Integer> setNegativeNums = new HashSet<>();
      int max = -1;
      for (int num : nums) {
        if (setNegativeNums.contains(-num)) {
          max = Math.max(max, Math.abs(num));
        }
        setNegativeNums.add(num);
      }
      return max;
    }
}
