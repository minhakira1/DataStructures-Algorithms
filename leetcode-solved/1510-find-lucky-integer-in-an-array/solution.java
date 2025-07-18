class Solution {
    public int findLucky(int[] arr) {
        int[] countNums = new int[501];
        for(int i=0;i<arr.length;i++){
            countNums[arr[i]]++;
        }
        int maxLuckyNum = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==countNums[arr[i]]){
                maxLuckyNum = Math.max(maxLuckyNum, arr[i]);
            }
        }
        return maxLuckyNum;
    }
}
