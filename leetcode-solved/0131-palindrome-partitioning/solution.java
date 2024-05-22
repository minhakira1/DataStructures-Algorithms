class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        List<List<String>> r = new ArrayList<>();
        dfs(r, s, 0, new ArrayList<>(), dp);
        return r;
    }

    void dfs(List<List<String>> r, String s, int start, List<String> path, boolean[][] dp) {
        int len = s.length();
        if (start >= len) r.add(new ArrayList<>(path));

        for (int i = start; i < len; i++) {
            //    i 
            // abca ...  //a == a, ok
            if (s.charAt(i) != s.charAt(start)) continue;
            //    i
            // abca ...   //b != c continue
            if (i - 1 > start + 1 && !dp[start + 1][i - 1]) continue;
            dp[start][i] = true;
            path.add(s.substring(start, i + 1));
            dfs(r, s, i + 1, path, dp);
            path.remove(path.size() - 1);
        }
    }
}
