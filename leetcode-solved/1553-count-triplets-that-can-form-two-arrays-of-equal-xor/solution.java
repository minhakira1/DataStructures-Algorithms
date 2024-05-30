class Solution {
  public int countTriplets(int[] arr) {
    int len = arr.length;
    int ans = 0;
    for (int i = 0; i < len - 1; i++) {
      int a = 0;
      for (int j = i + 1; j < len; j++) {
        a ^= arr[j - 1];
        int b = 0;
        for (int k = j; k < len; k++) {
          b ^= arr[k];
          if (a == b)
            ans++;
        }
      }
    }
    return ans;
  }
}
