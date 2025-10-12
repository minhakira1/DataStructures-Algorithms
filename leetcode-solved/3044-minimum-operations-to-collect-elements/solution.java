class Solution {
    public int minOperations(List<Integer> nums, int k) {
        // cause need to make a collection from 1 to k
        // so k is max number and the collection has k elements
        // nice one
        int minOperation = 0;
        int elementCount = 0;
        Set<Integer> hashSetCollection = new HashSet<>();
        for (int i = nums.size()-1; i >= 0; i--) {
            minOperation += 1;
            int num = nums.get(i);
            if (num <= k && hashSetCollection.add(num)) {
                elementCount += 1;
            }
            if (elementCount == k) {
                break;
            }
        }
        return minOperation;
    }
}
