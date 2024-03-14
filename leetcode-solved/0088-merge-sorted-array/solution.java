class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
          // hehe nice xu luon :3
        if (n == 0)
            return;
        int idx2 = 0;
        int idx1 = 0;
        int[] clone1m = Arrays.copyOfRange(nums1, 0, m);
        for (int i = 0; i < m + n ; i++) {
            if(idx1 == m) {
                nums1[i] = nums2[idx2];
                ++idx2;
            } else if (idx2 == n) {
              nums1[i] = clone1m[idx1];
                ++idx1;
            } else if (clone1m[idx1] > nums2[idx2]) {
                nums1[i] = nums2[idx2];
                ++idx2;
            } else if (clone1m[idx1] < nums2[idx2]) {
                nums1[i] = clone1m[idx1];
                ++idx1;
            } else if (clone1m[idx1] == nums2[idx2]) {
                nums1[i] = clone1m[idx1];
                ++idx1;
            }
        }
    }
}
