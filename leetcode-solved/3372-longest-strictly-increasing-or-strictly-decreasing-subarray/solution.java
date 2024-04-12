class Solution {
     public static int longestMonotonicSubarray(int[] nums) {
       int countIncrease = 1, countDecrease = 1;
       int longestIncrease = 1, longestDecrease = 1;
       for (int i = 1; i < nums.length; i++) {
           if (nums[i-1] < nums[i]) {
             countIncrease++;
             if (countIncrease > longestIncrease)
               longestIncrease = countIncrease;
           } else {
             countIncrease = 1;
           }
           if (nums[i-1] > nums[i]) {
             countDecrease++;
             if (countDecrease > longestDecrease)
               longestDecrease = countDecrease;
           } else {
             countDecrease = 1;
           }
         }
       return Math.max(longestIncrease, longestDecrease);
     }
}
