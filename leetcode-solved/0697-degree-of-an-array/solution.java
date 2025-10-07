class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        Map<Integer, Integer> firstIdx = new HashMap<>();
        Map<Integer, Integer> lastIdx = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = frequency.getOrDefault(nums[i], 0) + 1;
            max = Math.max(max, count);
            frequency.put(nums[i], count);
            if (!firstIdx.containsKey(nums[i])) {
                firstIdx.put(nums[i], i);
            }
            lastIdx.put(nums[i], i);
        }
        int minArray = nums.length;
        for (int key : frequency.keySet()) {
            if (frequency.get(key) == max) {
                minArray = Math.min(lastIdx.get(key) - firstIdx.get(key) + 1, minArray);
            }
        }
        return minArray;
    }
}
