class Solution {
  public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
    int sumSatisfied = 0;
    int len = customers.length;
    for (int i = 0; i < len; i++) {
      if (grumpy[i] == 0)
        sumSatisfied += customers[i];
    }
    int idx = 0, maxConvertSatify = Integer.MIN_VALUE;
    int sumWindow = 0;
    // sliding windowm conaldev
    while (idx + minutes <= len) {
      if (idx == 0) {
        for (int i = idx; i < idx + minutes; i++) {
          if (grumpy[i] == 1)
            sumWindow += customers[i];
        }
      } else {
        if (grumpy[idx-1] == 1)
          sumWindow -= customers[idx-1];
        if (grumpy[idx+minutes-1] == 1)
          sumWindow += customers[idx+minutes-1];
      }
      maxConvertSatify = Math.max(maxConvertSatify, sumWindow);
      idx++;
    }
    return sumSatisfied + maxConvertSatify;
  }
}
