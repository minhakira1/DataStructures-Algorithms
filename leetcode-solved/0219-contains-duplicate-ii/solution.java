class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> uniqueNums = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(i > k) {
                uniqueNums.remove(nums[i-k-1]);
            }
            if(uniqueNums.contains(nums[i]) == false) {
                uniqueNums.add(nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }
}
