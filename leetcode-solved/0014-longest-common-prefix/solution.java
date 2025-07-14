class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = 200;
        String minWord = "";
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
                minWord = strs[i];
            }
        }
        String ans = minWord;
        for (int j = minLen - 1; j >= 0; j--) {
            for (int i = 0; i < strs.length; i++) {
                String word = strs[i];
                if (word.charAt(j) != minWord.charAt(j)) {
                    ans = minWord.substring(0, j);
                    break;
                }
            }
        }
        return ans;
    }
}
