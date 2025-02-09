class Solution {
    public long countBadPairs(int[] nums) {
        // total pairs = nice + bad
        // => bad = total pairs - nice
        // j - i != A[j] - A[i]
        // => j - A[j] != i - A[i]
        long countGoods = 0;
        long n = nums.length;
        long total_pairs = (n *(n-1+0))/2; // total pairs = sum indexs from 0 to n -1
        Map<Integer, Long> goodPairsMap = new HashMap<>();
        for(int i=0;i<n;i++) {
            Long goodPairsValue= goodPairsMap.getOrDefault(i - nums[i],0L);
            countGoods+= goodPairsValue;
            goodPairsMap.put(i - nums[i], goodPairsValue + 1);
        }
        return total_pairs - countGoods;
    }
}
