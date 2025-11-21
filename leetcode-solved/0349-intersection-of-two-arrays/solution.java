class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = Math.min(len1, len2);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len1; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> setResult = new HashSet<>();
        for (int i = 0; i < len2; i++) {
            if (set.contains(nums2[i])) {
                setResult.add(nums2[i]);
            }
        }
        int[] result = new int[setResult.size()];
        int idx = 0;
        for (Integer v : setResult) {
            result[idx++] = v;
        }
        return result;
    }
}
