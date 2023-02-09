class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
          Map<Character, Integer> charsCount = new HashMap<>();
        for (Character ch : ransomNote.toCharArray()) {
            if (charsCount.containsKey(ch)) {
                charsCount.put(ch, charsCount.get(ch) + 1);
            } else {
                charsCount.put(ch, 1);
            }
        }
        for (Character ch : magazine.toCharArray()) {
            if (charsCount.containsKey(ch)) {
                Integer currentValue = charsCount.get(ch);
                if (currentValue <= 1) {
                    charsCount.remove(ch);
                } else {
                    charsCount.put(ch, currentValue - 1);
                }
            }
        }
        return charsCount.values().stream().noneMatch(val -> val > 0);
    }
}
