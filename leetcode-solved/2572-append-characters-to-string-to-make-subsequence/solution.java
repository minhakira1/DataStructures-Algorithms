class Solution {
  public int appendCharacters(String s, String t) {
    int tIdx = 0;
    for (char c : s.toCharArray()) {
      if (c == t.charAt(tIdx)) {
        tIdx++;
        if (tIdx == t.length())
          return 0;
      }
    }
    return t.length() - tIdx;
  }
}
