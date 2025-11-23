class Solution {
    public long sumAndMultiply(int n) {
        String stringValue = String.valueOf(n);
        int len = stringValue.length();
        StringBuilder x = new StringBuilder(len);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (stringValue.charAt(i) != '0') {
                sum += Integer.parseInt(String.valueOf(stringValue.charAt(i)));
                x.append(stringValue.charAt(i));
            }
        }
        if (x.isEmpty()) {
            return 0;
        }
        return Long.parseLong(x.toString()) * sum;
    }
}
