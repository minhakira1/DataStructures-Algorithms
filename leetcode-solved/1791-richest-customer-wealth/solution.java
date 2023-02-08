class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for(int cusIdx = 0; cusIdx < accounts.length; cusIdx++) {
            int cusWealth = 0;
            for (int bankIdx = 0; bankIdx < accounts[cusIdx].length; bankIdx++) {
                cusWealth += accounts[cusIdx][bankIdx];
            }
            maxWealth = Math.max(cusWealth, maxWealth);
        }
        return maxWealth;
    }
}
