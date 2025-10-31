class Solution {
    public int findClosest(int x, int y, int z) {
        int range1 = Math.abs(x-z);
        int range2 = Math.abs(y-z);
        if(range1 < range2)
            return 1;
        if(range2 < range1)
            return 2;
        return 0;
    }
}
