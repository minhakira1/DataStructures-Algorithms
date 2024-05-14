class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxValue = Math.max(maxValue,
                        recursiveValue(grid, i, j, m,n));
            }
        }
        return maxValue;
    }

    public int recursiveValue(int[][] grid, int row,
                              int col, int m, int n) {
        if (col < 0 || col >= n || row < 0 || row >= m || grid[row][col] == 0)
            return 0;
        int maxGold = Integer.MIN_VALUE;
        int originalValue = grid[row][col];
        grid[row][col] = 0;
        maxGold = Math.max(maxGold, recursiveValue(grid, row, col+1, m, n));
        maxGold = Math.max(maxGold, recursiveValue(grid, row+1, col, m, n));
        maxGold = Math.max(maxGold, recursiveValue(grid, row, col-1, m, n));
        maxGold = Math.max(maxGold, recursiveValue(grid, row-1, col, m, n));
        grid[row][col] = originalValue;
        return originalValue + maxGold;
    }
}
