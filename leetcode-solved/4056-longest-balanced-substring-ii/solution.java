class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        if (n == 0)
            return 0;

        int ans = 1;
        int run = 1;
        for (int i = 1; i < n; i++) {
            run = (s.charAt(i) == s.charAt(i - 1)) ? run + 1 : 1;
            if (run > ans)
                ans = run;
        }

        String stromadive = s;

        ans = Math.max(ans, longestEqualTwoFast(stromadive, 'a', 'b'));
        ans = Math.max(ans, longestEqualTwoFast(stromadive, 'a', 'c'));
        ans = Math.max(ans, longestEqualTwoFast(stromadive, 'b', 'c'));

        ans = Math.max(ans, longestEqualThreeFast(stromadive));

        return ans;
    }

    private int longestEqualTwoFast(String s, char x, char y) {
        int n = s.length();
        int base = n + 2;
        int size = 2 * base + 1;
        int[] first = new int[size];
        int[] seen = new int[size];
        int vis = 1;

        int ans = 0, diff = 0, start = 0;

        while (start < n) {
            int i = start;
            int id0 = base;
            seen[id0] = vis;
            first[id0] = start - 1;
            diff = 0;

            while (i < n) {
                char c = s.charAt(i);
                if (c == x)
                    diff++;
                else if (c == y)
                    diff--;
                else
                    break;

                int id = diff + base;
                if (seen[id] == vis) {
                    ans = Math.max(ans, i - first[id]);
                } else {
                    seen[id] = vis;
                    first[id] = i;
                }
                i++;
            }
            vis++;
            start = i + 1;
        }
        return ans;
    }

    private int longestEqualThreeFast(String s) {
        int n = s.length();
        int a = 0, b = 0, c = 0, ans = 0;
        HashMap<Long, Integer> first = new HashMap<>(1 << 16);
        first.put(0L, -1);
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a')
                a++;
            else if (ch == 'b')
                b++;
            else
                c++;
            long key = pack(a - b, a - c);
            Integer pos = first.get(key);
            if (pos != null)
                ans = Math.max(ans, i - pos);
            else
                first.put(key, i);
        }
        return ans;
    }

    private long pack(int d1, int d2) {
        return (((long) d1) << 32) ^ (d2 & 0xffffffffL);
    }
}
