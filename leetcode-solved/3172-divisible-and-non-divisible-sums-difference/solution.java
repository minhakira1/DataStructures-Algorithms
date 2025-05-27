class Solution {
    public int differenceOfSums(int n, int m) {
        int sumAll = (1+n)*n/2;
        int sum2 = 0;
        if(n>=m){
            for(int num=m;num<=n; num+=m){
                sum2 += num;
            }
        } 
        int sum1 = sumAll - sum2;
        return sum1 - sum2;
    }
}
