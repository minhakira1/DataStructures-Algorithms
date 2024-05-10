public class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3)
            return false;
        boolean hasVowel = false;
        boolean hasConsonant = false;
        String vowel = "ueoaiUEOAI";
        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (!hasVowel && vowel.indexOf(ch) >= 0)
                    hasVowel = true;
                if (!hasConsonant && vowel.indexOf(ch) < 0)
                    hasConsonant = true;
            } else if (!Character.isDigit(ch)) {
                return false; // Invalid character if not a letter or digit
            }
        }
        return hasVowel && hasConsonant;
    }
}
