class Solution {
    public int countOperations(int num1, int num2) {
        int count = 0;
        while(Math.min(num1, num2) > 0){
            if(num1 < num2){
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
            count += num1 / num2; // so nguyen lan operation cua 2 so. VD: 9/3 = 3 operations
            num1 %= num2; // neu ko phai 2 so chia het thi tiep tuc operation count;
            // con neu da chia het tuc la 1 so min nay = 0 thi done operation
        }
        return count;
    }
}
