class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    Set<String> stringSet = new HashSet<>();
    recursiveArray(nums, subsets, "", stringSet, 0, null);
    recursiveArray(nums, subsets, "", stringSet, 0, nums[0]);
    return subsets;
  }

     public void recursiveArray(int[] nums, List<List<Integer>> subsets, String value,
                               Set<String> stringSet, int idx, Integer num) {
        if (idx == nums.length)
            return;
        if (num == null) {
            if (stringSet.add(value)) {
                if (value.isEmpty()) {
                    subsets.add(new ArrayList<>());
                } else {
                    subsets.add(Arrays.stream(value.split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()));
                }
            }
        } else {
            value += nums[idx] + " ";
            if (stringSet.add(value))
                subsets.add(Arrays.stream(value.split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));
        }
        recursiveArray(nums, subsets, value, stringSet, idx+1 , null);
        recursiveArray(nums, subsets, value, stringSet, idx+1 , 1);
    }

}
