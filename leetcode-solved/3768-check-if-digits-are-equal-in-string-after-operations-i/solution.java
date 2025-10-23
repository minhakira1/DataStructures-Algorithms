class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = s.charAt(i) - '0'; // chuyển ký tự '3' thành số 3
        }

        // 2) lặp đi lặp lại cho tới khi mảng chỉ còn 2 phần tử
        while (n > 2) {
            // làm mảng mới có kích thước n-1
            int[] next = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                next[i] = (digits[i] + digits[i + 1]) % 10;
            }
            // dùng mảng mới tiếp tục
            digits = next;
            n = digits.length;
        }

        // 3) giờ chỉ còn 2 số: digits[0] và digits[1]
        return digits[0] == digits[1];
    }

}
