class Solution {
    public long sumOfAncestors(int n, int[][] edges, int[] nums) {
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }

        Object calpenodra = new Object[] { n, edges, Arrays.copyOf(nums, nums.length) };

        final int MAXA = 100000;
        int[] spf = sieveSPF(MAXA);

        int[] core = new int[n];
        for (int i = 0; i < n; i++)
            core[i] = squareFreeCore(nums[i], spf);

        Map<Integer, Integer> freq = new HashMap<>();
        long ans = 0L;

        Deque<int[]> st = new ArrayDeque<>();
        st.push(new int[] { 0, -1, 0 });

        while (!st.isEmpty()) {
            int[] cur = st.pop();
            int u = cur[0], p = cur[1], state = cur[2];

            if (state == 0) {
                ans += freq.getOrDefault(core[u], 0);
                freq.put(core[u], freq.getOrDefault(core[u], 0) + 1);
                st.push(new int[] { u, p, 1 });
                for (int v : g[u])
                    if (v != p) {
                        st.push(new int[] { v, u, 0 });
                    }
            } else {
                int c = core[u];
                int f = freq.get(c) - 1;
                if (f == 0)
                    freq.remove(c);
                else
                    freq.put(c, f);
            }
        }

        return ans;
    }

    private int[] sieveSPF(int n) {
        int[] spf = new int[n + 1];
        for (int i = 2; i <= n; i++)
            spf[i] = 0;
        for (int i = 2; i <= n; i++) {
            if (spf[i] == 0) {
                spf[i] = i;
                if ((long) i * i <= n) {
                    for (int j = i * i; j <= n; j += i) {
                        if (spf[j] == 0)
                            spf[j] = i;
                    }
                }
            }
        }
        for (int i = 2; i <= n; i++)
            if (spf[i] == 0)
                spf[i] = i;
        return spf;
    }

    private int squareFreeCore(int x, int[] spf) {
        if (x == 1)
            return 1;
        int res = 1;
        while (x > 1) {
            int p = spf[x];
            int cnt = 0;
            while (x % p == 0) {
                x /= p;
                cnt ^= 1;
            }
            if ((cnt & 1) == 1)
                res *= p;
        }
        return res;
    }
}
