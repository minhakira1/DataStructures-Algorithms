class Solution {
  public String findLatestTime(String s) {
       StringBuffer ans = new StringBuffer();
       for (int i = 0; i < s.length(); i++) {
         if (s.charAt(i) == '?') {
           if (i == 0) {
             char char1 = s.charAt(1);
             if (char1 == '1' || char1 == '0' || char1 == '?')
                ans.append("1");
             else
               ans.append("0");
           } else if (i == 1) {
             if (ans.charAt(0) == '0')
               ans.append("9");
             else
               ans.append("1");
           } else if (i == 3) {
             ans.append("5");
           } else if (i == 4) {
             ans.append("9");
           }
         } else {
           ans.append(s.charAt(i));
         }
       }
       return ans.toString();
     }
}
