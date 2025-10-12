class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
         Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (count % k == 0) {
                sum += num * count; 
            }
        }
        return sum;
    }
}
