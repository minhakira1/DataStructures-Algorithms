class Solution {
  public static int maximumUniqueSubarray(int[] nums) {
    int len = nums.length;
    int maxUniqueSub = 0;
    int currentScore = 0;
    Set<Integer> uniqueElements = new HashSet<>();
    for (int l = 0, r = 0; r < len; r++) {
      currentScore += nums[r];
      while (!uniqueElements.add(nums[r])) {
         currentScore -= nums[l];
         uniqueElements.remove(nums[l]);
         l++;
      }
      maxUniqueSub = Math.max(currentScore, maxUniqueSub);
    }
    return maxUniqueSub;
  }
}
