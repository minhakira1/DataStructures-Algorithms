class Solution {
    public static int maxDifference(String s) {
        int maxOddFreq = Integer.MIN_VALUE;
        int minEvenFreq = Integer.MAX_VALUE;
        int len = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < len; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int f : freq) {
            if (f % 2 == 0 && f != 0) {
                minEvenFreq = Math.min(minEvenFreq, f);
            } else if (f % 2 != 0) {
                maxOddFreq = Math.max(maxOddFreq, f);
            }
        }
        if (maxOddFreq == Integer.MIN_VALUE || minEvenFreq == Integer.MAX_VALUE) {
            return -1;
        }
        return maxOddFreq - minEvenFreq;
    }
}
