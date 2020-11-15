class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum =0;
        for(int i=0;i<arr.length;i++){
            int length = 1;
            while(length<=arr.length) {
                int j =i;
                if(j+length>arr.length)
                    break;
                int plus = 0;
                while(plus<length) {
                    sum+=arr[j];
                    j++;
                    ++plus;
                }
                length+=2;  
            }
            
    }
        return sum;
}
}
