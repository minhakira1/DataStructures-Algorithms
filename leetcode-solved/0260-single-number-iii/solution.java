class Solution {
  public int[] singleNumber(int[] nums) {
    int n = nums.length;
    int[] ans = new int[2];
    Map<Integer, Integer> mapCount = new HashMap<>();
    for (int i = 0; i < n; i++) {
      mapCount.put(nums[i], mapCount.getOrDefault(nums[i], 0) + 1);
    }
    for (int key : mapCount.keySet()) {
      if (mapCount.get(key) == 1) {
        if (ans[0] == ans[1])
          ans[0] = key;
        else
          ans[1] = key;
      }
    }
    return ans;
  }
}
