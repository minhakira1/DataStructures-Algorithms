class Solution {
    public boolean isAnagram(String s, String t) {
        int[] countChars = new int[26];
        for(int i = 0;i <s.length(); i++) {
          countChars[s.charAt(i) - 'a']++;
        }
        for(int i = 0;i <t.length(); i++) {
          countChars[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
          if(countChars[i] != 0)
            return false;
        }
        return true;
    }
}
