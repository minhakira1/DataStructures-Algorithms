class Solution {
    public int balancedStringSplit(String s) {
        int balanced = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch == 'L')
                balanced++;
            else if (ch == 'R')
                balanced--;
            if (balanced == 0) {
                res++;
            }
        }
        return res;
    }
}
