class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xorDerived = 0;
        for(int i=0;i<derived.length;i++){
            xorDerived ^= derived[i];
        }
        return xorDerived == 0;
    }
}
