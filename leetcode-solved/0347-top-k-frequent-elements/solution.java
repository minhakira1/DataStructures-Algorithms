class Solution {
  public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> keyCounts = new HashMap<>();
    for (int num : nums) {
      keyCounts.put(num, keyCounts.getOrDefault(num, 0) + 1);
    }
    List<Integer> buckets[] = new List[nums.length + 1];
    for (int key : keyCounts.keySet()) {
      int frequence = keyCounts.get(key);
      if (buckets[frequence] == null)
        buckets[frequence] = new ArrayList<>();
      buckets[frequence].add(key);
    }
    List<Integer> ans = new ArrayList<>(k);
    for (int i = buckets.length - 1; i >= 0 && k > 0; i--) {
      if (buckets[i] == null)
        continue;
      for (int keyIdx = 0; keyIdx < buckets[i].size() && k > 0; keyIdx++) {
        ans.add(buckets[i].get(keyIdx));
        k--;
      }
    }
    return ans.stream().mapToInt(Integer::intValue).toArray();
  }
}
