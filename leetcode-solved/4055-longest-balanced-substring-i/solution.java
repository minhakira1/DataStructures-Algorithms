class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        if (n == 0)
            return 0;

        int ans = 0;
        final int ALPHA = 26;
        char[] arr = s.toCharArray();

        for (int k = 1; k <= ALPHA; k++) {
            for (int f = 1; k * f <= n; f++) {
                int L = k * f;
                int[] cnt = new int[ALPHA];
                int pos = 0;
                int eqF = 0;

                int left = 0;
                for (int right = 0; right < n; right++) {
                    int rc = arr[right] - 'a';
                    int before = cnt[rc];
                    int after = ++cnt[rc];

                    if (before == 0)
                        pos++;
                    if (before == f)
                        eqF--;
                    if (after == f)
                        eqF++;

                    if (right - left + 1 > L) {
                        int lc = arr[left++] - 'a';
                        before = cnt[lc];
                        after = --cnt[lc];

                        if (before == f)
                            eqF--;
                        if (after == f)
                            eqF++;
                        if (after == 0)
                            pos--;
                    }

                    if (right - left + 1 == L) {
                        if (pos == k && eqF == k) {
                            ans = Math.max(ans, L);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
