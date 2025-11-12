class Solution {
    public int totalMoney(int n) {
        int countWeek = n / 7;
        int remainDays = n - countWeek * 7;
        int sumRemainDays = (countWeek+1 + countWeek+1 + remainDays -1) * remainDays / 2;
        int result = sumRemainDays;
        int idx = 1;
        while(idx <= countWeek){
            result += (idx + (idx +6)) * 7 /2;
            idx++;
        }
        return result;
    }
}
