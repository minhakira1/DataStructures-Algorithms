class Solution {
    public int maxChunksToSorted(int[] arr) {
        int len = arr.length;
        if(len == 1) 
            return 1;
        int countChunk = 0;
        int maxCurrent = 0;
        for(int i=0;i<len;i++) {
            maxCurrent = Math.max(maxCurrent, arr[i]);

            if (maxCurrent == i) {
                // All values in range [0, i] belong to the prefix arr[0:i]; a new chunk can be formed
                countChunk++;
            }
        }
        return countChunk;
    }
}
