class Solution {
    public int minAddToMakeValid(String s) {
       int closeRes = 0;
       Stack<Character> stackOpen = new Stack<>();
       for (Character c : s.toCharArray()) {
           if (c == '(') {
             stackOpen.push(c);
           } else {
               if (stackOpen.isEmpty())
                   closeRes++;
               else
                  stackOpen.pop();
           }
       }
       return stackOpen.size() + closeRes;
    }
}
