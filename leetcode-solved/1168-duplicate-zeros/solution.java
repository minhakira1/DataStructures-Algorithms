class Solution {
    public void duplicateZeros(int[] arr) {
        int length_idx = arr.length - 1;
        int count0Dup = 0;
        for (int i = 0; i <= length_idx - count0Dup; i++) {
            if(arr[i] == 0) {
                 if (i == length_idx - count0Dup) {
                    // Last zero
                    // For this zero we just copy it without duplication.
                    arr[length_idx] = 0;
                    length_idx -= 1;
                    break;
                }
                count0Dup++;
            }
        }
        for (int i = length_idx - count0Dup; i >= 0; i--) {
            if(arr[i] == 0) {
                arr[i + count0Dup] = 0;
                count0Dup--;
                arr[i + count0Dup] = 0;
            } else {
                arr[i + count0Dup] = arr[i];
            }
        }
    }
  
}
