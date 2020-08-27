class Solution {
    public int sumSquareNum(int num) {
        int sum = 0;
        while(num>0){
            int temp = num%10;
            sum += Math.pow(temp,2);
            num/=10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int tortoise = n;
        int hare =n;
        do {
            tortoise = sumSquareNum(tortoise);
            hare = sumSquareNum(hare);
            if(hare==1)
                return true;
            hare = sumSquareNum(hare);
            if(hare==1)
                return true;
        } while(hare!=tortoise);
        if(tortoise==1) return true;
        return false;
    }
}
