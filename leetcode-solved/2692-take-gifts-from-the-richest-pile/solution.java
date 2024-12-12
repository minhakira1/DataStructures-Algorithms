class Solution {
    public long pickGifts(int[] gifts, int k) {
        long sumRemainGifts = 0;
        while (k > 0) {
            int max = 1;
            int idxMax = 0;
            for (int i = 0; i < gifts.length; i++) {
                if (max < gifts[i]) {
                    max = gifts[i];
                    idxMax = i;
                }
            }
            gifts[idxMax] = (int) Math.sqrt(gifts[idxMax]);
            k--;
        }
        for (int i = 0; i < gifts.length; i++) {
            sumRemainGifts += gifts[i];
        }
        return sumRemainGifts;
    }
}
