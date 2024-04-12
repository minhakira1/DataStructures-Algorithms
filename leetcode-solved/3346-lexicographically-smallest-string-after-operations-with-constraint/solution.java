class Solution {
public String getSmallestString(String s, int k) {
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
