class Solution {
    public boolean isValid(String s) {
       Deque<Character> stack = new ArrayDeque<>();
        String openBracket = "[({";
        String closeBracket = "])}";
        for (int i = 0; i < s.length(); i++) {
            int idx = openBracket.indexOf(s.charAt(i));
            if (idx > -1) {
                stack.push(closeBracket.charAt(idx));
            } else {
                if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
