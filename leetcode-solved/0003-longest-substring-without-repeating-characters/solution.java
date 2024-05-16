class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 1)
      return 1;
    int maxLength = 0;
    StringBuilder subString = new StringBuilder(s.length());
    for (int i = 0; i < s.length(); i++) {
      String c = String.valueOf(s.charAt(i));
      int idxC = subString.indexOf(c);
      if (idxC > -1) {
        subString = new StringBuilder(subString.substring(idxC + 1, subString.length()));
      }
      subString.append(c);
      if (subString.length() > maxLength)
        maxLength = subString.length();

    }
    return maxLength;
  }
}
