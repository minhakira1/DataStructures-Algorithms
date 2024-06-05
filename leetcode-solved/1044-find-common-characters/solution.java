class Solution {
  public List<String> commonChars(String[] words) {
    List<String> commonChars = new ArrayList<>();
    HashMap<Character, Integer> charsCount = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      HashMap<Character, Integer> cloneMap = new HashMap<>(charsCount);
      charsCount = new HashMap<>();
      for (char c : words[i].toCharArray()) {
        if (i == 0) {
          charsCount.put(c, charsCount.getOrDefault(c, 0) + 1);
        } else {
          Integer value = cloneMap.get(c);
          if (value != null) {
            value--;
            cloneMap.put(c, value);
            if (value >= 0) {
              charsCount.put(c, charsCount.getOrDefault(c, 0) + 1);
            }
          }
        }
      }
      if (charsCount.keySet().isEmpty())
        return commonChars;
    }
    for (Character c : charsCount.keySet()) {
      int val = charsCount.get(c);
      while (val > 0) {
        commonChars.add(c.toString());
        val--;
      }
    }
    return commonChars;
  }
}
