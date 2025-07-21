class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));
        for(int i=1;i<s.length();i++){
            Character ch = s.charAt(i);
            if(s.charAt(i-1) == ch && i < s.length() -1
                && s.charAt(i+1) == ch)
                continue;
            else
                ans.append(ch);
        }
        return ans.toString();
    }
}
