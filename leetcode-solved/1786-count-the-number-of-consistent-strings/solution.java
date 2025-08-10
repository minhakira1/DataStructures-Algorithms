class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] charsAllow = new int[26];
        for(char ch : allowed.toCharArray()){
            charsAllow[ch - 'a']++;
        }
        int result = 0;
        for(String word : words){
            boolean isAllow = true;
            for(char ch : word.toCharArray()){
                if(charsAllow[ch-'a'] == 0){
                    isAllow = false;
                    break;
                }
            }
            if(isAllow)
                ++result;
        }
        return result;
    }
}
