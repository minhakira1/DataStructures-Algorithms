public class LeetCode {
  public static void main(String[] args) {
//    int[] nums = {3,2,1};
//    System.out.println(longestMonotonicSubarray(nums));
//    System.out.println(getSmallestString("lol", 0));
    int[] arr = plusOne(new int[]{2, 9, 9});
    for (int i = 0; i < arr.length ; i++) {
      System.out.println(arr[i]);
    }

  }

  public static int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }
      digits[i] = 0;
    }

    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;
  }



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

     public static String getSmallestString(String s, int k) {
      StringBuilder ans = new StringBuilder(s.length());
       for (int i = 0; i < s.length(); i++) {
         if (k == 0) {
           ans.append(s.charAt(i));
           continue;
         }

         int distanceToAFromZ = 'z' - s.charAt(i) + 1;
         int distanceToAFromA = s.charAt(i) - 'a';
         if (distanceToAFromA <= k || distanceToAFromZ <= k) {
           if (distanceToAFromA <= distanceToAFromZ) {
             ans.append((char) (s.charAt(i) - distanceToAFromA));
             if (distanceToAFromA <= k) {
               k = k - distanceToAFromA;
             } else {
               k = 0;
             }
           } else {
             ans.append("a");
             if (distanceToAFromZ <= k) {
               k = k - distanceToAFromZ;
             } else {
               k = 0;
             }
           }
         } else {
           ans.append((char) (s.charAt(i) - k));
           k = 0;
         }
       }
       return ans.toString();
     }
}