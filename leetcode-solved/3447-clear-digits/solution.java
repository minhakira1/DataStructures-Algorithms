class Solution {
  public String clearDigits(String s) {
    int n = s.length();
    List<Character> chars = new ArrayList<>();
    int countNums = 0;
    StringBuilder res = new StringBuilder(s.length());
    for (int i = n - 1; i >= 0; i--) {
      char ch = s.charAt(i);
      if (Character.isDigit(ch)) {
        countNums += 1;
      } else if (countNums > 0) {
        countNums--;
      } else {
        chars.add(ch);
      }
    }
    for (int i = chars.size() - 1; i >= 0; i--) {
      res.append(chars.get(i));
    }
    return res.toString();
  }
}
