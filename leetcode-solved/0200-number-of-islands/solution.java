class Solution {
    public int numIslands(char[][] grid) {
        int sumIslands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    ++sumIslands;
                    DFSfill0(grid, row, col);
                }
            }
        }
        return sumIslands;
    }

    private void DFSfill0(char[][] grid, int row, int col) {
        if (row >= 0 && col >= 0 && row < grid.length && col < grid[row].length
            && grid[row][col] == '1') {
                grid[row][col] = '0';
                DFSfill0(grid, row + 1, col);
                DFSfill0(grid, row - 1, col);
                DFSfill0(grid, row, col - 1);
                DFSfill0(grid, row, col + 1);
            }
        }
}
