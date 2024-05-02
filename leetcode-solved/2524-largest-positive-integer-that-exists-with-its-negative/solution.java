class Solution {
    public int findMaxK(int[] nums) {
      Set<Integer> setNums = new HashSet<>();
      int max = -1;
      for (int num : nums) {
        if (setNums.contains(-num)) {
          max = Math.max(max, Math.abs(num));
        }
        setNums.add(num);
      }
      return max;
    }
}
