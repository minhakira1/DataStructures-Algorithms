class Solution {
  public long sumDigitDifferences(int[] nums) {
    int n = nums.length;
    int numDigits = String.valueOf(nums[0]).length();
    int[][] digitCounts = new int[numDigits][10];

    for (int num : nums) {
      String s = String.valueOf(num);
      for (int i = 0; i < numDigits; i++) {
        digitCounts[i][s.charAt(i) - '0']++;
      }
    }

    long totalDifferences = 0;
    for (int i = 0; i < numDigits; i++) {
      for (int d1 = 0; d1 <= 9; d1++) {
        for (int d2 = d1+1; d2 <= 9; d2++) {
          if (d1 != d2) {
            totalDifferences += (long)digitCounts[i][d1] * digitCounts[i][d2];
          }
        }
      }
    }
    return totalDifferences;
  }
}
