class Solution {
    public String[] findWords(String[] words) {
        Set<Character> row1 = stringToCharSet("qwertyuiop");
        Set<Character> row2 = stringToCharSet("asdfghjkl");
        Set<Character> row3 = stringToCharSet("zxcvbnm");
        List<String> res = new ArrayList();
        for (String word : words) {
            if (isValidInOneRow(row1, word) || isValidInOneRow(row2, word) || isValidInOneRow(row3, word)) {
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }

    boolean isValidInOneRow(Set<Character> row, String word) {
        for (char c : word.toCharArray()) {
            if (!row.contains(Character.toLowerCase(c)))
                return false;
        }
        return true;
    }

    Set<Character> stringToCharSet(String str) {
        Set<Character> set = new HashSet();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        return set;
    }
}
