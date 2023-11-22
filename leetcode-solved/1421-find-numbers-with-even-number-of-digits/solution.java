class Solution {
    public int findNumbers(int[] nums) {
        int countEven = 0;
        for (int num : nums) {
            int count = 1;
            num = num /10;
            while(num > 0) {
                num = num /10;
                count++;
            }
            if (count % 2 == 0) {
                ++countEven;
            }
        }
        return countEven;
    }
}
