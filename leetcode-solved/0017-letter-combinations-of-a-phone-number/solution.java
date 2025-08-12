class Solution {
    private String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        backtrack("", digits, 0);
        return result;
    }

    private void backtrack(String combination, String digits, int index) {
        // Base case: If we've processed all digits, we've found a complete combination
        if (index == digits.length()) {
            result.add(combination);
            return;
        }

        // Get the letters for the current digit
        String letters = mapping[digits.charAt(index) - '0'];

        // Recursive step: explore all possible letters for the current digit
        for (char letter : letters.toCharArray()) {
            // Append the current letter and move to the next digit
            backtrack(combination + letter, digits, index + 1);
        }
    }
}
