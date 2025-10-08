class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for(int i=0;i<32;i++){
            //Step 1: Get the last bit right of n
            int lastBit = n & 1;
            //Step 2: Move result to the left to make space for new bit
            result = result << 1; //2^0 = 1 make a 0 to new space
            //Step 3: Put the lastBit to the new space of result
            result = result | lastBit;
            //Step 4: Move n to the next last bit right
            n = n >> 1;
        }
        return result;
    }
}
