class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        int i = 0;
        Arrays.sort(happiness);
        while (k > 0) {
            ans += happiness[happiness.length - i - 1];
            k--;
            i++;
            if (i < happiness.length && happiness[happiness.length - i - 1] > 0)
                happiness[happiness.length - i - 1] = happiness[happiness.length - i - 1] - i >= 0
                 ? happiness[happiness.length - i - 1] - i : 0;
        }
        return ans;
    }
}
